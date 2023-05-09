package model;

import java.util.ArrayList;

public class PersistenceRecords {
    private ArrayList<TestRecord> records;

    public PersistenceRecords() {
        records = new ArrayList<TestRecord>();
    }

    public TestRecord getRecord(int index) {
        return records.get(index);
    }
}
