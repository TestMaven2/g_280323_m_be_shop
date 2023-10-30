package de.telran.g_280323_m_be_shop.domain.database.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Database {

    void execute(String query) throws SQLException;

    List<Object> select(String query) throws SQLException;
}