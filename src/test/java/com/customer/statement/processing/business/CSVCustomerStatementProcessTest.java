package com.customer.statement.processing.business;

import static org.junit.Assert.assertEquals;

import com.customer.statement.processing.business.CSVCustomerStatementProcessing;
import com.customer.statement.processing.dataprovider.TestData;
import com.customer.statement.processing.exception.CSVCustomerStatementProcessingException;
import com.customer.statement.processing.model.Record;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CSVCustomerStatementProcessTest {

    @InjectMocks
    private CSVCustomerStatementProcessing csvCustomerStatementProcess;

    @Test
    public void testExecute() throws CSVCustomerStatementProcessingException {
        Pair<Set<Record>, List<Record>> resultSet = TestData.getSetListPair();
        assertEquals(resultSet, csvCustomerStatementProcess.execute("./upload/records-test.csv"));
     }

}
