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
package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;

public class EntityDataAdapterDiffblueTest {
  /**
   * Test {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   *
   * <p>Method under test: {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityDataAdapter.createEntityData(EntityDataPageLink, List, List, int)"
  })
  public void testCreateEntityData() {
    // Arrange
    EntityDataPageLink pageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());
    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();

    // Act
    PageData<EntityData> actualCreateEntityDataResult =
        EntityDataAdapter.createEntityData(pageLink, selectionMapping, new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertFalse(actualCreateEntityDataResult.hasNext());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
  }

  /**
   * Test {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return hasNext.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityDataAdapter.createEntityData(EntityDataPageLink, List, List, int)"
  })
  public void testCreateEntityData_givenThree_thenReturnHasNext() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    pageLink.setPageSize(3);
    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();

    // Act
    PageData<EntityData> actualCreateEntityDataResult =
        EntityDataAdapter.createEntityData(pageLink, selectionMapping, new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
    assertTrue(actualCreateEntityDataResult.hasNext());
  }

  /**
   * Test {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List, int)}.
   *
   * <ul>
   *   <li>When {@link EntityDataPageLink#EntityDataPageLink()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#createEntityData(EntityDataPageLink, List, List,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EntityDataAdapter.createEntityData(EntityDataPageLink, List, List, int)"
  })
  public void testCreateEntityData_whenEntityDataPageLink_thenReturnNotHasNext() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<EntityKeyMapping> selectionMapping = new ArrayList<>();

    // Act
    PageData<EntityData> actualCreateEntityDataResult =
        EntityDataAdapter.createEntityData(pageLink, selectionMapping, new ArrayList<>(), 1);

    // Assert
    assertEquals(1, actualCreateEntityDataResult.getTotalPages());
    assertEquals(1L, actualCreateEntityDataResult.getTotalElements());
    assertFalse(actualCreateEntityDataResult.hasNext());
    assertTrue(actualCreateEntityDataResult.getData().isEmpty());
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenDot_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", EntityDataAdapter.convertValue("."));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", EntityDataAdapter.convertValue(""));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", EntityDataAdapter.convertValue(42));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenMinusOne_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("-1", EntityDataAdapter.convertValue(-1));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", EntityDataAdapter.convertValue(null));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", EntityDataAdapter.convertValue("Value"));
  }

  /**
   * Test {@link EntityDataAdapter#convertValue(Object)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataAdapter#convertValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityDataAdapter.convertValue(Object)"})
  public void testConvertValue_whenZero_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", EntityDataAdapter.convertValue(0));
  }
}
