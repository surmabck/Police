/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.policeserver.database;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.cases.PoliceCase;
import model.cases.PoliceCaseState;
import model.person.Person;
import model.person.suspect.Suspect;
import model.person.user.User;
import model.person.user.UserType;
import model.person.witness.Witness;
import pl.policeserver.PoliceServer;

/**
 * Klasa która służy do komunikacji z baza danych. Tworzy swoj obiekt na
 * podstawie pliku databaseConnection.properties
 *
 * @author Krzysztof Surdy
 */
public class DatabaseConnector {

    private static String dbdriv;
    private static String dburl;
    private static String dbusr;
    private static String dbpass;
    /**
     * Stala okreslajaca możliwosc zbicia innych pionków przy wykonywaniu ruchu
     */
    public static final boolean NOKILL = false;
    /**
     * Stala okreslajaca niemożność zbicia innych pionków przy wykonywaniu ruchu
     */
    public static final boolean KILL = true;
    private Connection con;
    private PreparedStatement loginStatement;
    private PreparedStatement peopleStatement;
    private PreparedStatement addPersonStatement;
    private PreparedStatement updatePersonStatement;
    private PreparedStatement deletePersonStatement;
    private PreparedStatement getOfficerCases;
    private PreparedStatement getCaseState;
    private PreparedStatement getCaseMember;
    private PreparedStatement addPoliceCase;
    private PreparedStatement addPoliceCaseMember;
    private PreparedStatement addPoliceCaseState;
    private PreparedStatement updatePoliceCase;
    private static DatabaseConnector instance;

    static {
        InputStream in = null;
        try /**
         * Konstruktor. Konstruuje obiekt na podstawie pliku
         * databaseConnection.properties
         */
        {
            Properties props = new Properties();
            in = PoliceServer.class.getResourceAsStream("/pl/policeserver/database/databaseConnection.properties");
            props.load(in);
            dburl = props.getProperty("jdbc.url");
            dbusr = props.getProperty("jdbc.username");
            dbpass = props.getProperty("jdbc.password");
            dbdriv = props.getProperty("jdbc.drivers");
            if (dbdriv != null) {
                System.setProperty("jdbc.drivers", dbdriv);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Nie mozna polaczyc sie z baza danych");
            System.exit(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Nie mozna polaczyc sie z baza danych");
            System.exit(0);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DatabaseConnector() {
        try {

            con = DriverManager.getConnection(dburl, dbusr, dbpass);
            loginStatement = con.prepareStatement(""
                    + "SELECT ID,LOGIN,PASSWORD,POLICE_RANK,ACC_TYPE,FIRSTNAME,SECONDNAME,AGE,PHONENUMBER,CITY,STREET,HOUSE,POSTALCODE \n"
                    + "  FROM FULL_OFFICER "
                    + "  WHERE LOGIN=? and PASSWORD=?");
            peopleStatement = con.prepareStatement(""
                    + "SELECT P.ID,P.FIRSTNAME,P.SECONDNAME,P.AGE,P.PHONENUMBER,A.CITY,A.STREET,A.HOUSE,A.POSTALCODE \n"
                    + "  FROM PERSON P JOIN ADDRESS A ON P.ADDRESS_ID = A.ID");
            addPersonStatement = con.prepareStatement(""
                    + "INSERT INTO FULL_PERSON(FIRSTNAME,SECONDNAME,AGE,PHONENUMBER,CITY,STREET,HOUSE,POSTALCODE) \n"
                    + "  values(?,?,?,?,?,?,?,?)");
            updatePersonStatement = con.prepareStatement(""
                    + "UPDATE  FULL_PERSON  \n"
                    + "  set\n"
                    + "    FIRSTNAME = ?,\n"
                    + "    SECONDNAME = ?,\n"
                    + "    AGE= ?,\n"
                    + "    PHONENUMBER  = ?,\n"
                    + "    CITY = ?,\n"
                    + "    STREET = ?,\n"
                    + "    HOUSE = ?,\n"
                    + "    POSTALCODE = ?\n"
                    + "  where\n"
                    + "    ID = ?");
            deletePersonStatement = con.prepareStatement(""
                    + "DELETE FROM PERSON WHERE ID = ?");
            getOfficerCases = con.prepareStatement(""
                    + "SELECT * FROM POLICECASE WHERE OFFICER_ID = ?");
            getCaseState = con.prepareStatement(""
                    + "SELECT * FROM STATE WHERE CASE_ID = ? ORDER BY STATUS_DATE ASC");
            getCaseMember = con.prepareStatement(""
                    + "SELECT C.CASE_ID,C.MEMBER_TYPE, P.ID,P.FIRSTNAME,P.SECONDNAME,P.AGE,P.PHONENUMBER,P.CITY,P.STREET,P.HOUSE,P.POSTALCODE \n"
                    + "  FROM\n"
                    + "    CASE_MEMBERS C JOIN FULL_PERSON P on C.PERSON_ID = P.ID \n"
                    + "  WHERE\n"
                    + "    C.CASE_ID = ?");
            addPoliceCase = con.prepareStatement(""
                    + "INSERT into POLICECASE(officer_id,header,description) "
                    + "values(?,?,?)");
            addPoliceCaseMember = con.prepareStatement(""
                    + "INSERT INTO FULL_CASE_MEMBERS("
                    + "CASE_ID,"
                    + "MEMBER_TYPE,"
                    + "FIRSTNAME,"
                    + "SECONDNAME,"
                    + "AGE,"
                    + "PHONENUMBER,"
                    + "CITY,"
                    + "STREET,"
                    + "HOUSE,"
                    + "POSTALCODE) \n"
                    + "  VALUES(?,?,?,?,?,?,?,?,?,?)");
            addPoliceCaseState = con.prepareStatement(""
                    + "INSERT INTO STATE "
                    + "(CASE_ID,VAL,STATUS_DATE) "
                    + "VALUES (?,?,?)");
            updatePoliceCase = con.prepareStatement(" "
                    + " UPDATE POLICECASE \n"
                    + "    SET \n"
                    + "      OFFICER_ID=?,\n"
                    + "      HEADER = ?,\n"
                    + "      DESCRIPTION = ?\n"
                    + "    WHERE\n"
                    + "      ID = ?");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public boolean updateCase(User u, PoliceCase policeCase) {
        Boolean ret = false;
        try {
            updatePoliceCase.setInt(1, u.getId());
            updatePoliceCase.setString(2, policeCase.getDescription());
            updatePoliceCase.setString(3, policeCase.getLongDescription());
            updatePoliceCase.setInt(4,policeCase.getId());
            updatePoliceCase.executeUpdate();
            for (Witness v : policeCase.getVictims()) {
                addCaseMember(v, "Victim", policeCase.getId());
            }
            for (Suspect s : policeCase.getSuspects()) {
                addCaseMember(s, "Suspect", policeCase.getId());
            }
            addCaseState(policeCase.getId(), policeCase.getState());
            ret = true;
        } catch (SQLException ex) {
            ret = false;
            System.out.println("Cannot update case");
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public void addCaseMember(Person v, String type, int caseId) {
        try {
            addPoliceCaseMember.setInt(1, caseId);
            addPoliceCaseMember.setString(2, "Victim");
            addPoliceCaseMember.setString(3, v.getName());
            addPoliceCaseMember.setString(4, v.getSurname());
            addPoliceCaseMember.setInt(5, v.getAge());
            addPoliceCaseMember.setInt(6, v.getPhoneNumber());
            addPoliceCaseMember.setString(7, v.getAddress().getCityName());
            addPoliceCaseMember.setString(8, v.getAddress().getStreetName());
            addPoliceCaseMember.setString(9, v.getAddress().getApartment());
            addPoliceCaseMember.setString(10, v.getAddress().getPostCode());
            addPoliceCaseMember.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Cannot add case member");
        }
    }

    public void addCaseState(int caseId, PoliceCaseState v) {
        String value = "Suspect";
        switch (v) {
            case completed:
                value = "Completed";
                break;
            case inProgress:
                value = "In Progress";
                break;
            case suspended:
                value = "Suspended";
                break;
        }
        try {
            addPoliceCaseState.setInt(1, caseId);
            addPoliceCaseState.setString(2, value);
            addPoliceCaseState.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            addPoliceCaseState.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addCase(User u, PoliceCase policeCase) {
        Boolean ret = false;
        Statement currvalStatement = null;
        String sql_currval = "SELECT POLICECASE_SEQ.CURRVAL FROM dual";
        ResultSet currvalResultSet = null;
        int caseId = 0;
        try {
            addPoliceCase.setInt(1, u.getId());
            addPoliceCase.setString(2, policeCase.getDescription());
            addPoliceCase.setString(3, policeCase.getLongDescription());
            addPoliceCase.executeUpdate();
            currvalStatement = con.createStatement();
            currvalResultSet = currvalStatement.executeQuery(sql_currval);
            if (currvalResultSet.next()) {
                caseId = currvalResultSet.getInt(1);
            }
            for (Witness v : policeCase.getVictims()) {
                addCaseMember(v, "Victim", caseId);
            }
            for (Suspect s : policeCase.getSuspects()) {
                addCaseMember(s, "Suspect", caseId);
            }
            addCaseState(caseId, policeCase.getState());
            ret = true;
        } catch (SQLException ex) {
            ret = false;
            System.out.println("Cannot add case");
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean deletePerson(Person p) {
        Boolean ret = false;
        try {
            deletePersonStatement.setInt(1, p.getId());
            deletePersonStatement.executeQuery();
            ret = true;
        } catch (SQLException ex) {
            ret = false;
            System.out.println("Cannot delete person");
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean getCases(List<PoliceCase> cases, User u) {
        Boolean ret = false;
        try {
            getOfficerCases.setInt(1, u.getId());
            ResultSet rs = getOfficerCases.executeQuery();
            while (rs.next()) {
                PoliceCase p = new PoliceCase();
                p.setId(rs.getInt("ID"));
                p.setDescription(rs.getString("HEADER"));
                p.setOfficer(u);
                getCaseState.setInt(1, p.getId());
                ResultSet rs2 = getCaseState.executeQuery();
                if (rs2.next()) {
                    if (rs2.getString("VAL").equalsIgnoreCase("In Progress")) {
                        p.setState(PoliceCaseState.inProgress);
                    } else if (rs2.getString("VAL").equalsIgnoreCase("Completed")) {
                        p.setState(PoliceCaseState.completed);
                    } else {
                        p.setState(PoliceCaseState.suspended);
                    }
                }
                rs2.close();
                getCaseMember.setInt(1, p.getId());
                ResultSet rs3 = getCaseMember.executeQuery();
                while (rs3.next()) {
                    if (rs3.getString("MEMBER_TYPE").equalsIgnoreCase("Victim")) {
                        Witness w = new Witness();
                        w.setAge(rs3.getInt("AGE"));
                        w.setName(rs3.getString("FIRSTNAME"));
                        w.setSurname(rs3.getString("SECONDNAME"));
                        w.setPhoneNumber(rs3.getInt("PHONENUMBER"));
                        w.getAddress().setApartment(rs3.getString("HOUSE"));
                        w.getAddress().setCityName(rs3.getString("CITY"));
                        w.getAddress().setPostCode(rs3.getString("POSTALCODE"));
                        w.getAddress().setStreetName(rs3.getString("STREET"));
                        w.setId(rs3.getInt("ID"));
                        w.setCredibility(0);
                        w.setIsRelatedWithSuspect(false);
                        w.setIsUnderProtection(false);
                        p.getVictims().add(w);
                    } else if (rs3.getString("MEMBER_TYPE").equalsIgnoreCase("Suspect")) {
                        Suspect w = new Suspect();
                        w.setAge(rs3.getInt("AGE"));
                        w.setName(rs3.getString("FIRSTNAME"));
                        w.setSurname(rs3.getString("SECONDNAME"));
                        w.setPhoneNumber(rs3.getInt("PHONENUMBER"));
                        w.getAddress().setApartment(rs3.getString("HOUSE"));
                        w.getAddress().setCityName(rs3.getString("CITY"));
                        w.getAddress().setPostCode(rs3.getString("POSTALCODE"));
                        w.getAddress().setStreetName(rs3.getString("STREET"));
                        w.setId(rs3.getInt("ID"));
                        w.setAmountOfCasesAgainst(0);
                        w.setCredibility(0);
                        p.getSuspects().add(w);
                    }
                }
                rs3.close();
                cases.add(p);
            }
            rs.close();
            ret = true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean addPerson(Person p) {
        Boolean ret = false;
        if (p.getId() == 0) {

            try {
                addPersonStatement.setString(1, p.getName());
                addPersonStatement.setString(2, p.getSurname());
                addPersonStatement.setInt(3, p.getAge());
                addPersonStatement.setInt(4, p.getPhoneNumber());
                addPersonStatement.setString(5, p.getAddress().getCityName());
                addPersonStatement.setString(6, p.getAddress().getStreetName());
                addPersonStatement.setString(7, p.getAddress().getApartment());
                addPersonStatement.setString(8, p.getAddress().getPostCode());
                addPersonStatement.executeQuery();
                ret = true;
            } catch (SQLException ex) {
                System.out.println("Cannot add person");
                ret = false;
            }
        } else {
            try {
                updatePersonStatement.setString(1, p.getName());
                updatePersonStatement.setString(2, p.getSurname());
                updatePersonStatement.setInt(3, p.getAge());
                updatePersonStatement.setInt(4, p.getPhoneNumber());
                updatePersonStatement.setString(5, p.getAddress().getCityName());
                updatePersonStatement.setString(6, p.getAddress().getStreetName());
                updatePersonStatement.setString(7, p.getAddress().getApartment());
                updatePersonStatement.setString(8, p.getAddress().getPostCode());
                updatePersonStatement.setInt(9, p.getId());
                updatePersonStatement.executeQuery();
                ret = true;
            } catch (SQLException ex) {
                System.out.println("Cannot update person");
                ret = false;
            }

        }
        return ret;
    }

    public List<Person> getPeople(User u) {
        List<Person> ret = new ArrayList<>();

        try {
            ResultSet rs = peopleStatement.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setAge(rs.getInt("AGE"));
                p.setName(rs.getString("FIRSTNAME"));
                p.setSurname(rs.getString("SECONDNAME"));
                p.setPhoneNumber(rs.getInt("PHONENUMBER"));
                p.getAddress().setApartment(rs.getString("HOUSE"));
                p.getAddress().setCityName(rs.getString("CITY"));
                p.getAddress().setPostCode(rs.getString("POSTALCODE"));
                p.getAddress().setStreetName(rs.getString("STREET"));
                p.setId(rs.getInt("ID"));
                ret.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return ret;
        }
    }

    public boolean loginUser(User user) {
        if (isInDatabase(user) != 0) {
            return true;
        }
        return false;
    }

    private int isInDatabase(User user) {
        int amount = 0;
        try {
            loginStatement.setString(1, user.getLogin());
            loginStatement.setString(2, user.getPassword());
            ResultSet rs = loginStatement.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("FIRSTNAME"));
                user.setSurname(rs.getString("SECONDNAME"));
                user.setPhoneNumber(rs.getInt("PHONENUMBER"));
                user.setAge(rs.getInt("AGE"));
                user.getAddress().setApartment(rs.getString("HOUSE"));
                user.getAddress().setCityName(rs.getString("CITY"));
                user.getAddress().setPostCode(rs.getString("POSTALCODE"));
                user.getAddress().setStreetName(rs.getString("STREET"));
                user.setId(rs.getInt("ID"));
                if (rs.getString("ACC_TYPE").equalsIgnoreCase("Supervisor")) {
                    user.setType(UserType.Supervisor);
                } else if (rs.getString("ACC_TYPE").equalsIgnoreCase("Standard")) {
                    user.setType(UserType.Officer);
                } else {
                    user.setType(UserType.Terminal);
                }
                amount++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }

}
