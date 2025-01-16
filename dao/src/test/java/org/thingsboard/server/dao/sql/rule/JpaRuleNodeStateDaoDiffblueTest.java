package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleNodeStateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleNodeStateDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaRuleNodeStateDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRuleNodeStateDao jpaRuleNodeStateDao;

  @MockBean
  private RuleNodeStateRepository ruleNodeStateRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRuleNodeStateDao#getEntityClass()}
   *   <li>{@link JpaRuleNodeStateDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleNodeStateDao jpaRuleNodeStateDao = new JpaRuleNodeStateDao();

    // Act
    Class<RuleNodeStateEntity> actualEntityClass = jpaRuleNodeStateDao.getEntityClass();

    // Assert
    assertNull(jpaRuleNodeStateDao.getRepository());
    Class<RuleNodeStateEntity> expectedEntityClass = RuleNodeStateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}
   */
  @Test
  public void testFindByRuleNodeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeStateRepository.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult = jpaRuleNodeStateDao
        .findByRuleNodeId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeStateRepository).findByRuleNodeId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByRuleNodeIdResult.getTotalElements());
    assertEquals(1, actualFindByRuleNodeIdResult.getTotalPages());
    assertFalse(actualFindByRuleNodeIdResult.hasNext());
    assertTrue(actualFindByRuleNodeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}
   */
  @Test
  public void testFindByRuleNodeId_thenReturnDataSizeIsOne() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = mock(RuleNodeStateEntity.class);
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateEntity.toData()).thenReturn(ruleNodeState);
    doNothing().when(ruleNodeStateEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(ruleNodeStateEntity).setRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setStateData(Mockito.<String>any());
    ruleNodeStateEntity.setCreatedTime(-1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("42");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("org.thingsboard.server.dao.model.sql.RuleNodeStateEntity");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeStateEntity> content = new ArrayList<>();
    content.add(ruleNodeStateEntity);
    PageImpl<RuleNodeStateEntity> pageImpl = new PageImpl<>(content);
    when(ruleNodeStateRepository.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult = jpaRuleNodeStateDao
        .findByRuleNodeId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeStateEntity).setCreatedTime(eq(-1L));
    verify(ruleNodeStateEntity).setId(isA(UUID.class));
    verify(ruleNodeStateEntity).setUuid(isA(UUID.class));
    verify(ruleNodeStateEntity).setEntityId(isA(UUID.class));
    verify(ruleNodeStateEntity).setEntityType(eq("42"));
    verify(ruleNodeStateEntity).setRuleNodeId(isA(UUID.class));
    verify(ruleNodeStateEntity).setStateData(eq("org.thingsboard.server.dao.model.sql.RuleNodeStateEntity"));
    verify(ruleNodeStateEntity).toData();
    verify(ruleNodeStateRepository).findByRuleNodeId(isA(UUID.class), isA(Pageable.class));
    List<RuleNodeState> data = actualFindByRuleNodeIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindByRuleNodeIdResult.getTotalElements());
    assertSame(ruleNodeState, data.get(0));
  }

  /**
   * Test {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}
   */
  @Test
  public void testFindByRuleNodeId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeStateRepository.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult = jpaRuleNodeStateDao
        .findByRuleNodeId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeStateRepository).findByRuleNodeId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByRuleNodeIdResult.getTotalElements());
    assertEquals(1, actualFindByRuleNodeIdResult.getTotalPages());
    assertFalse(actualFindByRuleNodeIdResult.hasNext());
    assertTrue(actualFindByRuleNodeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeStateDao#findByRuleNodeIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeStateDao#findByRuleNodeIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testFindByRuleNodeIdAndEntityId_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = mock(RuleNodeStateEntity.class);
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateEntity.toData()).thenReturn(ruleNodeState);
    doNothing().when(ruleNodeStateEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(ruleNodeStateEntity).setRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleNodeStateEntity).setStateData(Mockito.<String>any());
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);
    when(ruleNodeStateRepository.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleNodeStateEntity);

    // Act
    RuleNodeState actualFindByRuleNodeIdAndEntityIdResult = jpaRuleNodeStateDao
        .findByRuleNodeIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleNodeStateEntity).setCreatedTime(eq(1L));
    verify(ruleNodeStateEntity).setId(isA(UUID.class));
    verify(ruleNodeStateEntity).setUuid(isA(UUID.class));
    verify(ruleNodeStateEntity).setEntityId(isA(UUID.class));
    verify(ruleNodeStateEntity).setEntityType(eq("Entity Type"));
    verify(ruleNodeStateEntity).setRuleNodeId(isA(UUID.class));
    verify(ruleNodeStateEntity).setStateData(eq("MD"));
    verify(ruleNodeStateEntity).toData();
    verify(ruleNodeStateRepository).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertSame(ruleNodeState, actualFindByRuleNodeIdAndEntityIdResult);
  }

  /**
   * Test {@link JpaRuleNodeStateDao#removeByRuleNodeId(UUID)}.
   * <p>
   * Method under test: {@link JpaRuleNodeStateDao#removeByRuleNodeId(UUID)}
   */
  @Test
  public void testRemoveByRuleNodeId() {
    // Arrange
    doNothing().when(ruleNodeStateRepository).removeByRuleNodeId(Mockito.<UUID>any());

    // Act
    jpaRuleNodeStateDao.removeByRuleNodeId(ModelConstants.NULL_UUID);

    // Assert that nothing has changed
    verify(ruleNodeStateRepository).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test {@link JpaRuleNodeStateDao#removeByRuleNodeIdAndEntityId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaRuleNodeStateDao#removeByRuleNodeIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testRemoveByRuleNodeIdAndEntityId() {
    // Arrange
    doNothing().when(ruleNodeStateRepository).removeByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any());

    // Act
    jpaRuleNodeStateDao.removeByRuleNodeIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert that nothing has changed
    verify(ruleNodeStateRepository).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }
}
