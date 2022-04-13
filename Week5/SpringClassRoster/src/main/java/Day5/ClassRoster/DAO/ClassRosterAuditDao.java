package Day5.ClassRoster.DAO;

public interface ClassRosterAuditDao {
    void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
