package org.thingsboard.server.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.sql.AttributeKvEntity;
import org.thingsboard.server.dao.sql.attributes.AttributeKvInsertRepository;

@ContextConfiguration(classes = {AttributeKvInsertRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class AbstractVersionedInsertRepositoryDiffblueTest {
  @Autowired
  private AbstractVersionedInsertRepository<AttributeKvEntity> abstractVersionedInsertRepository;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}.
   *
   * <p>Method under test: {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}
   */
  @Test
  @DisplayName("Test saveOrUpdate(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractVersionedInsertRepository.saveOrUpdate(List)"})
  void testSaveOrUpdate() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Long> actualSaveOrUpdateResult =
        abstractVersionedInsertRepository.saveOrUpdate(new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertTrue(actualSaveOrUpdateResult.isEmpty());
  }
}
