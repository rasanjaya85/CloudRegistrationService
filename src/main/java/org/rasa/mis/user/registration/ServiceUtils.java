/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.rasa.mis.user.registration;

import org.rasa.mis.user.registration.beans.Card;
import org.rasa.mis.user.registration.beans.User;
import java.io.IOException;

import java.sql.*;
import java.util.Properties;

/**
 * Utils for the API
 */
public  class ServiceUtils {


    public static final String FIELD_FIRST_NAME = "first_name";
    public static final String FIELD_LAST_NAME = "last_name";
    public static final String
            FIELD_DATE_CREATED = "date_created";
    public static final String FIELD_IS_ADMIN = "is_admin";
    public static final String FIELD_NUM_POINTS = "num_points";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_EMAIL = "email";

    private static Properties dbProperties = new Properties();
    static {
        try {
            dbProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbProperties.getProperty("db_driver"));
        return DriverManager.getConnection(dbProperties.getProperty("db_url"), dbProperties.getProperty("db_username"), dbProperties.getProperty("db_password"));
    }

    public static User getUserById(int userId) throws SQLException, ClassNotFoundException {
        User user = new User();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String selectQuery = "SELECT * FROM users WHERE id=" + userId;
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString(FIELD_FIRST_NAME));
            user.setLastName(resultSet.getString(FIELD_LAST_NAME));
            user.setAddress(resultSet.getString(FIELD_ADDRESS));
            user.setEmail(resultSet.getString(FIELD_EMAIL));
            //user.setDateCreated(new Date(10000));
            break;
        }

        statement.close();
        //connection.close();
        if (user.getFirstName() != null){
            return user;
        }

        return null;
    }


    public static Card getCardbyID(int id) throws ClassNotFoundException, SQLException {
        Card card = new Card();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String selectQuery = "SELECT * FROM cards WHERE id=" + id;
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            card.setId(resultSet.getInt("id"));
            card.setBank(resultSet.getString("bank"));
            card.setCardNo(resultSet.getString("card_no"));
            card.setValidMonth(resultSet.getInt("valid_month"));
            card.setValidYear(resultSet.getInt("valid_year"));
            break;
        }

        statement.close();
        //connection.close();
        return card;
    }

    public static void addUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String insertQuery = "INSERT INTO users (" +
                FIELD_FIRST_NAME + ", " +
                FIELD_LAST_NAME + ", " +
                FIELD_ADDRESS + ", " +
                FIELD_EMAIL + ") VALUES(" +
                "'" + user.getFirstName() + "', " +
                "'" + user.getLastName() + "', " +
                "'" + user.getAddress() + "', " +
                "'" + user.getEmail() + "')";
        statement.executeUpdate(insertQuery);
    }
}
