package main.java.by.bsuir.wt.fourth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import main.java.by.bsuir.wt.fourth.controller.command.Command;
import main.java.by.bsuir.wt.fourth.controller.command.CommandFactory;
import main.java.by.bsuir.wt.fourth.controller.command.CommandResult;
import main.java.by.bsuir.wt.fourth.controller.context.RequestContextHelper;
import main.java.by.bsuir.wt.fourth.dao.connection.ConnectionPool;
import main.java.by.bsuir.wt.fourth.exeptions.ConnectionException;


public class Controller extends HttpServlet {

    private static final String COMMAND = "command";
    private static final String PATH = "/hotel?";
    private static final String MAIN_COMMAND = "command=main";

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionPool.getInstance().initialize();
        } catch (ConnectionException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    public void destroy() {
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);

        if (commandName == null || "".equals(commandName)) {
            response.sendRedirect(PATH + MAIN_COMMAND);
        } else {
            Command command = CommandFactory.getInstance().getCommand(commandName);
            RequestContextHelper contextHelper = new RequestContextHelper(request);

            CommandResult result = command.execute(contextHelper, response);
            dispatch(result, request, response);
        }
    }

    private void dispatch(CommandResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (result.isRedirect()) {
            response.sendRedirect(PATH + result.getPage());
        } else {
            request.getRequestDispatcher(result.getPage()).forward(request, response);
        }
    }
}