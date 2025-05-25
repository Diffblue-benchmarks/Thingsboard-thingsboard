package org.thingsboard.server.dao.sql.relation;

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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;
import org.thingsboard.server.dao.model.sql.RelationEntity;

@RunWith(MockitoJUnitRunner.class)
public class SqlRelationInsertRepositoryDiffblueTest {
  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private SqlRelationInsertRepository sqlRelationInsertRepository;

  /**
   * Test {@link SqlRelationInsertRepository#saveOrUpdate(List)} with {@code entities}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlRelationInsertRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SqlRelationInsertRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdateWithEntities_whenArrayList_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(Mockito.<PreparedStatementCreator>any(), Mockito.<BatchPreparedStatementSetter>any(),
        Mockito.<KeyHolder>any())).thenReturn(new int[]{1, -1, 1, -1});

    // Act
    List<RelationEntity> actualSaveOrUpdateResult = sqlRelationInsertRepository.saveOrUpdate(new ArrayList<>());

    // Assert
    verify(jdbcTemplate).batchUpdate(isA(PreparedStatementCreator.class), isA(BatchPreparedStatementSetter.class),
        isA(KeyHolder.class));
    assertTrue(actualSaveOrUpdateResult.isEmpty());
  }
}
