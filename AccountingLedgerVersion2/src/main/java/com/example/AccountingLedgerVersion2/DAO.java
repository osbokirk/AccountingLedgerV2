package com.example.AccountingLedgerVersion2;

import java.sql.*;


public class DAO {
    public ResultSet showAllLedgers(int userId) throws SQLException {
        String query = "{CALL ShowAllLedgers(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }

    public ResultSet showAllDeposits(int userId) throws SQLException {
        String query = "{CALL ShowAllDeposits(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }

    public ResultSet showAllPayments(int userId) throws SQLException {
        String query = "{CALL ShowAllPayments(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }
    public ResultSet showReportsByMonthToDate(int userId) throws SQLException {
        String query = "{CALL ShowReportsByMonthToDate(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }

    public ResultSet showReportsByPreviousMonth(int userId) throws SQLException {
        String query = "{CALL ShowReportsByPreviousMonth(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }

    public ResultSet showReportsByYearToDate(int userId) throws SQLException {
        String query = "{CALL ShowReportsByYearToDate(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }

    public ResultSet showReportsByPreviousYear(int userId) throws SQLException {
        String query = "{CALL ShowReportsByPreviousYear(?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }

    public ResultSet searchByVendor(int userId, String vendor) throws SQLException {
        String query = "{CALL SearchByVendor(?, ?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        statement.setString(2, vendor);
        return statement.executeQuery();
    }

    public ResultSet customSearch(int userId, Date startDate, Date endDate, String vendor) throws SQLException {
        String query = "{CALL CustomSearch(?, ?, ?, ?)}";
        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setInt(1, userId);
        statement.setDate(2, startDate);
        statement.setDate(3, endDate);
        statement.setString(4, vendor.isEmpty() ? "%" : vendor);
        return statement.executeQuery();
    }
    public void addDeposit(int userId, String description, String vendor, double amount) throws SQLException {
        String query = "{CALL AddDeposit(?, ?, ?, ?)}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement statement = conn.prepareCall(query)) {

            statement.setInt(1, userId);
            statement.setString(2, description);
            statement.setString(3, vendor);
            statement.setDouble(4, amount);
            statement.executeUpdate();
        }
    }

    public void makePayment(int userId, String description, String vendor, double amount) throws SQLException {
        String query = "{CALL MakePayment(?, ?, ?, ?)}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement statement = conn.prepareCall(query)) {

            statement.setInt(1, userId);
            statement.setString(2, description);
            statement.setString(3, vendor);
            statement.setDouble(4, amount);
            statement.executeUpdate();
        }
    }
}
