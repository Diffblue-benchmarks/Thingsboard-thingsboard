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
package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.AssetEntity;

public class BaseVersionedEntityDiffblueTest {
  /**
   * Test {@link BaseVersionedEntity#getVersion()}.
   *
   * <p>Method under test: {@link BaseVersionedEntity#getVersion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BaseVersionedEntity.getVersion()"})
  public void testGetVersion() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getVersion());
  }

  /**
   * Test {@link BaseVersionedEntity#setVersion(Long)}.
   *
   * <p>Method under test: {@link BaseVersionedEntity#setVersion(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseVersionedEntity.setVersion(Long)"})
  public void testSetVersion() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act
    assetEntity.setVersion(1L);

    // Assert
    assertEquals(1L, assetEntity.toData().getVersion().longValue());
    assertEquals(1L, assetEntity.getVersion().longValue());
  }
}
