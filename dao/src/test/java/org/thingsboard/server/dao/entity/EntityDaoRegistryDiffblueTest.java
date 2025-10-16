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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.Dao;

@ContextConfiguration(classes = {EntityDaoRegistry.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityDaoRegistryDiffblueTest {
  @MockBean private Dao<Object> dao;

  @Autowired private EntityDaoRegistry entityDaoRegistry;

  @Autowired private List<Dao<Object>> list;

  /**
   * Test {@link EntityDaoRegistry#getDao(EntityType)}.
   *
   * <p>Method under test: {@link EntityDaoRegistry#getDao(EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dao EntityDaoRegistry.getDao(EntityType)"})
  public void testGetDao() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityDaoRegistry.getDao(EntityType.TENANT));
  }
}
