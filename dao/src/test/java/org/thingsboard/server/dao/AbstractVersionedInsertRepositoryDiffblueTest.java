package org.thingsboard.server.dao;

import static org.junit.Assert.assertTrue;
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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.sql.AttributeKvEntity;
import org.thingsboard.server.dao.sql.attributes.AttributeKvInsertRepository;

@ContextConfiguration(classes = {AttributeKvInsertRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractVersionedInsertRepositoryDiffblueTest {
  @Autowired
  private AbstractVersionedInsertRepository<AttributeKvEntity> abstractVersionedInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}.
   * <p>
   * Method under test: {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractVersionedInsertRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Long> actualSaveOrUpdateResult = abstractVersionedInsertRepository.saveOrUpdate(new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertTrue(actualSaveOrUpdateResult.isEmpty());
  }
}
