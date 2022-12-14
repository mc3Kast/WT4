package main.java.by.bsuir.wt.fourth.dao.impl;

import java.util.Optional;

import main.java.by.bsuir.wt.fourth.dao.AbstractDao;
import main.java.by.bsuir.wt.fourth.dao.Table;
import main.java.by.bsuir.wt.fourth.dao.api.RoleDao;
import main.java.by.bsuir.wt.fourth.dao.mapper.RowMapperFactory;
import main.java.by.bsuir.wt.fourth.exeptions.DaoException;

public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    private static final String SAVE_ROLE_QUERY = "INSERT INTO " + Table.ROLE + " (role) VALUES (?)";
    private static final String FIND_ROLE_BY_NAME_QUERY = "SELECT * FROM " + Table.ROLE + " WHERE role=?";

    public RoleDaoImpl() {
        super(RowMapperFactory.getInstance().getRoleRowMapper(), Table.ROLE);
    }

    @Override
    public int save(Role role) throws DaoException {
        return executeInsertQuery(SAVE_ROLE_QUERY, role.getName());
    }

    @Override
    public Optional<Role> findByName(String name) throws DaoException {
        return executeQueryForSingleResult(FIND_ROLE_BY_NAME_QUERY, name);
    }
}
