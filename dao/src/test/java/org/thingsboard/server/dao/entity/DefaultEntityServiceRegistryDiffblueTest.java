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
package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;

@ContextConfiguration(classes = {DefaultEntityServiceRegistry.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultEntityServiceRegistryDiffblueTest {
  @Autowired private DefaultEntityServiceRegistry defaultEntityServiceRegistry;

  @MockBean private EntityDaoService entityDaoService;

  @Autowired private List<EntityDaoService> list;

  /**
   * Test {@link DefaultEntityServiceRegistry#init()}.
   *
   * <ul>
   *   <li>Given {@link EntityDaoService} {@link EntityDaoService#getEntityType()} return {@code
   *       RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEntityServiceRegistry.init()"})
  public void testInit_givenEntityDaoServiceGetEntityTypeReturnRuleChain() {
    // Arrange
    when(entityDaoService.getEntityType()).thenReturn(EntityType.RULE_CHAIN);

    // Act
    defaultEntityServiceRegistry.init();

    // Assert
    verify(entityDaoService).getEntityType();
  }

  /**
   * Test {@link DefaultEntityServiceRegistry#init()}.
   *
   * <ul>
   *   <li>Given {@link EntityDaoService} {@link EntityDaoService#getEntityType()} return {@code
   *       TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEntityServiceRegistry.init()"})
  public void testInit_givenEntityDaoServiceGetEntityTypeReturnTenant() {
    // Arrange
    when(entityDaoService.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultEntityServiceRegistry.init();

    // Assert
    verify(entityDaoService).getEntityType();
  }

  /**
   * Test {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}.
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityDaoService DefaultEntityServiceRegistry.getServiceByEntityType(EntityType)"
  })
  public void testGetServiceByEntityType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultEntityServiceRegistry.getServiceByEntityType(EntityType.TENANT));
  }
}
