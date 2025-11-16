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
package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TbSqlQueueElementDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqlQueueElement#TbSqlQueueElement(SettableFuture, Object)}
   *   <li>{@link TbSqlQueueElement#toString()}
   *   <li>{@link TbSqlQueueElement#getEntity()}
   *   <li>{@link TbSqlQueueElement#getFuture()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlQueueElement.<init>(SettableFuture, Object)",
    "Object TbSqlQueueElement.getEntity()",
    "SettableFuture TbSqlQueueElement.getFuture()",
    "String TbSqlQueueElement.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();

    // Act
    TbSqlQueueElement<Object, Object> actualTbSqlQueueElement =
        new TbSqlQueueElement<>(future, "Entity");
    String actualToStringResult = actualTbSqlQueueElement.toString();
    Object actualEntity = actualTbSqlQueueElement.getEntity();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("TbSqlQueueElement(entity=Entity)", actualToStringResult);
    assertSame(future, actualTbSqlQueueElement.getFuture());
  }
}
