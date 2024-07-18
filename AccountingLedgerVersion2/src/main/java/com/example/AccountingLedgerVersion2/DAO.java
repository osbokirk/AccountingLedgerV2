package com.example.AccountingLedgerVersion2;

import java.sql.*;


public class DAO {
    public ResultSet showAllLedgers() throws SQLException {

        String query = "{CALL ShowAllLedgers}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);

        return statement.executeQuery();
    }

    public ResultSet showAllDeposits() throws SQLException {

        String query = "{CALL ShowAllDeposits}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);

        return statement.executeQuery();
    }

    public ResultSet showAllPayments() throws SQLException {

        String query = "{CALL ShowAllPayments}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);

        return statement.executeQuery();
    }
    public ResultSet showReportsByMonthToDate(Date startDate) throws SQLException {

        String query = "{CALL ShowReportsByMonthToDate(?)}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setDate(1, startDate);
        return statement.executeQuery();
    }

    public ResultSet showReportsByPreviousMonth(Date startDate, Date endDate) throws SQLException {

        String query = "{CALL ShowReportsByPreviousMonth(?,?)}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setDate(1, startDate);
        statement.setDate(2, endDate);
        return statement.executeQuery();
    }

    public ResultSet showReportsByYearToDate(Date startDate) throws SQLException {

        String query = "{CALL ShowReportsByYearToDate(?)}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setDate(1, startDate);
        return statement.executeQuery();
    }

    public ResultSet showReportsByPreviousYear(Date startDate, Date endDate) throws SQLException {

        String query = "{CALL ShowReportsByPreviousYear(?,?)}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);
        statement.setDate(1, startDate);
        statement.setDate(2, endDate);
        return statement.executeQuery();
    }

    public ResultSet searchByVendor(String vendor) throws SQLException {

        String query = "{CALL SearchByVendor(?)}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);

        statement.setString(1, vendor);
        return statement.executeQuery();
    }

    public ResultSet customSearch(Date startDate, Date endDate, String vendor) throws SQLException {

        String query = "{CALL CustomSearch(?, ?, ?)}";

        Connection conn = DatabaseConnection.getConnection();
        CallableStatement statement = conn.prepareCall(query);

        statement.setDate(1, startDate);
        statement.setDate(2, endDate);
        statement.setString(3, vendor.isEmpty() ? "%" : vendor);
        return statement.executeQuery();
    }
    public void addDeposit(String description, String vendor, double amount) throws SQLException {

        String query = "{CALL AddDeposit(?, ?, ?)}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement statement = conn.prepareCall(query)) {

            statement.setString(1, description);
            statement.setString(2, vendor);
            statement.setDouble(3, amount);
            statement.executeUpdate();
        }
    }

    public void makePayment(String description, String vendor, double amount) throws SQLException {

        String query = "{CALL MakePayment(?, ?, ?)}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement statement = conn.prepareCall(query)) {

            statement.setString(1, description);
            statement.setString(2, vendor);
            statement.setDouble(3, amount);
            statement.executeUpdate();
        }
    }
}
