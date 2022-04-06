package Day2.vendingmachine.dao;

import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class VendingMachineAuditFileImpl implements VendingMachineAuditDao{
    public static final String AUDIT_FILE = "C:\\Users\\Ramon Lorente\\Desktop\\c184-Java-React\\Week3\\src\\Day2\\vendingmachine\\dao\\VendingMachineAuditFile";
    @Override
    public void writeAuditEntry(String entry) throws VendingMachineNoItemInventoryException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingMachineNoItemInventoryException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
}
