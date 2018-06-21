package com.customer.statement.processing;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.test.context.TestPropertySource;

import com.customer.statement.processing.controller.CustomerStatementUploadController;
import com.customer.statement.processing.dataprovider.CustomerStatementProcessingProvider;
import com.customer.statement.processing.dataprovider.TestData;
import com.customer.statement.processing.exception.CSVCustomerStatementProcessingException;
import com.customer.statement.processing.exception.CustomerStatementProcessingException;
import com.customer.statement.processing.exception.XMLCustomerStatementProcessingException;
import com.customer.statement.processing.model.Record;
import com.customer.statement.processing.service.CustomerStatementFinalReportService;
import com.customer.statement.processing.utils.FileExtensionFilter;



@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({FileExtensionFilter.class})
public class AppTest {

	@Mock
	CustomerStatementFinalReportService customerStatementErrorReportService;
	@Mock
	CustomerStatementProcessingProvider customerStatementProcessingProvider;
	@InjectMocks
	CustomerStatementUploadController customerStatementUploadController;
	
    @Test
    public void testApp() throws CustomerStatementProcessingException, CSVCustomerStatementProcessingException, XMLCustomerStatementProcessingException, Exception {
    	Pair<Set<Record>, List<Record>> resultSet = TestData.getSetListPair();
    	Mockito.when(customerStatementProcessingProvider.getFileLocation()).thenReturn(resultSet);
        String result = customerStatementUploadController.invoke();
        assertEquals(result, "Your file has been Processed Successfully!!! Please check the Report.csv file is there any errors. "
                + "You Can find the file in following location Upload location");
    }
}
