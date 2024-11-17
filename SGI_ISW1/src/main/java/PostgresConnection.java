public class PostgresConnection {

    /**
     * Connect to a PostgreSQL database.
     *
     * @param url the JDBC URL to connect to. Must start with "jdbc:postgresql:"
     * @param user the username for the connection
     * @param password the password for the connection
     * @return a Connection object for the established connection
     * @throws ClassNotFoundException if the driver class cannot be found on the Java classpath
     * @throws java.sql.SQLException if connection to the database fails
     */
    public static java.sql.Connection connect(String url, String user, String password)
            throws ClassNotFoundException, java.sql.SQLException {

        // Register the PostgreSQL JDBC driver
        Class.forName("org.postgresql.Driver");

        // Create properties object for connection parameters
        java.util.Properties props = new java.util.Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        // Optional: prevent server-prepared statements
        props.setProperty("prepareThreshold", "0");

        // Connect to the database using the DriverManager
        return java.sql.DriverManager.getConnection(url, props);
    }
}