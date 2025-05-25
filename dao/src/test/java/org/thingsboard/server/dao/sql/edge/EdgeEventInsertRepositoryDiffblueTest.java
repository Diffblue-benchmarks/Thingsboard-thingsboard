package org.thingsboard.server.dao.sql.edge;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@ContextConfiguration(classes = {EdgeEventInsertRepository.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class EdgeEventInsertRepositoryDiffblueTest {
  @Autowired
  private EdgeEventInsertRepository edgeEventInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link EdgeEventInsertRepository#save(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventInsertRepository#save(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeEventInsertRepository.save(List)"})
  public void testSave_whenArrayList() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");

    // Act
    edgeEventInsertRepository.save(new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }
}
