package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.model.sql.RuleNodeEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleNodeDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRuleNodeDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRuleNodeDao jpaRuleNodeDao;

  @MockBean
  private RuleNodeRepository ruleNodeRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRuleNodeDao#getEntityClass()}
   *   <li>{@link JpaRuleNodeDao#getEntityType()}
   *   <li>{@link JpaRuleNodeDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaRuleNodeDao.getEntityClass()", "EntityType JpaRuleNodeDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaRuleNodeDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleNodeDao jpaRuleNodeDao = new JpaRuleNodeDao();

    // Act
    Class<RuleNodeEntity> actualEntityClass = jpaRuleNodeDao.getEntityClass();
    EntityType actualEntityType = jpaRuleNodeDao.getEntityType();

    // Assert
    assertNull(jpaRuleNodeDao.getRepository());
    assertEquals(EntityType.RULE_NODE, actualEntityType);
    Class<RuleNodeEntity> expectedEntityClass = RuleNodeEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaRuleNodeDao.findAllRuleNodeByIds(List)"})
  public void testFindAllRuleNodeByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   * <p>
   * Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaRuleNodeDao.deleteByIdIn(List)"})
  public void testDeleteByIdIn() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    jpaRuleNodeDao.deleteByIdIn(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   * <p>
   * Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaRuleNodeDao.deleteByIdIn(List)"})
  public void testDeleteByIdIn2() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleNodeIds.add(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    jpaRuleNodeDao.deleteByIdIn(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link CrudRepository#deleteAllById(Iterable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaRuleNodeDao.deleteByIdIn(List)"})
  public void testDeleteByIdIn_whenArrayList_thenCallsDeleteAllById() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    // Act
    jpaRuleNodeDao.deleteByIdIn(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }
}
