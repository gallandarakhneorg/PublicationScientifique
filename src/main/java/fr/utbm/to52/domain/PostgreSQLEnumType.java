package fr.utbm.to52.domain;

import org.hibernate.HibernateException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class PostgreSQLEnumType extends org.hibernate.type.EnumType {

    public void nullSafeSet(
            PreparedStatement st,
            Object value,
            int index)
            throws HibernateException, SQLException {
        if(value == null) {
            st.setNull( index, Types.OTHER );
        }
        else {
            st.setObject(
                    index,
                    value.toString(),
                    Types.OTHER
            );
        }
    }
}