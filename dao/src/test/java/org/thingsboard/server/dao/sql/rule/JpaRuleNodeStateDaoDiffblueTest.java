/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Map;
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
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaRuleNodeStateDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaRuleNodeStateDao jpaRuleNodeStateDao;

  @MockBean private RuleNodeStateRepository ruleNodeStateRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaRuleNodeStateDao#getEntityClass()}
   *   <li>{@link JpaRuleNodeStateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaRuleNodeStateDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaRuleNodeStateDao.getRepository()"
  })
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleNodeStateDao.findByRuleNodeId(UUID, PageLink)"})
  public void testFindByRuleNodeId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(ruleNodeStateRepository.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult =
        jpaRuleNodeStateDao.findByRuleNodeId(ModelConstants.NULL_UUID, pageLink);

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
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaRuleNodeStateDao#findByRuleNodeId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaRuleNodeStateDao.findByRuleNodeId(UUID, PageLink)"})
  public void testFindByRuleNodeId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeStateRepository.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult =
        jpaRuleNodeStateDao.findByRuleNodeId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeStateRepository).findByRuleNodeId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByRuleNodeIdResult.getTotalElements());
    assertEquals(1, actualFindByRuleNodeIdResult.getTotalPages());
    assertFalse(actualFindByRuleNodeIdResult.hasNext());
    assertTrue(actualFindByRuleNodeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeStateDao#removeByRuleNodeId(UUID)}.
   *
   * <p>Method under test: {@link JpaRuleNodeStateDao#removeByRuleNodeId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaRuleNodeStateDao.removeByRuleNodeId(UUID)"})
  public void testRemoveByRuleNodeId() {
    // Arrange
    doNothing().when(ruleNodeStateRepository).removeByRuleNodeId(Mockito.<UUID>any());

    // Act
    jpaRuleNodeStateDao.removeByRuleNodeId(ModelConstants.NULL_UUID);

    // Assert
    verify(ruleNodeStateRepository).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test {@link JpaRuleNodeStateDao#removeByRuleNodeIdAndEntityId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaRuleNodeStateDao#removeByRuleNodeIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaRuleNodeStateDao.removeByRuleNodeIdAndEntityId(UUID, UUID)"})
  public void testRemoveByRuleNodeIdAndEntityId() {
    // Arrange
    doNothing()
        .when(ruleNodeStateRepository)
        .removeByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any());

    // Act
    jpaRuleNodeStateDao.removeByRuleNodeIdAndEntityId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleNodeStateRepository).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }
}
