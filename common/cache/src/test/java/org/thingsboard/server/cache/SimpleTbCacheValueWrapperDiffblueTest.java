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
package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

class SimpleTbCacheValueWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleTbCacheValueWrapper#toString()}
   *   <li>{@link SimpleTbCacheValueWrapper#get()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object SimpleTbCacheValueWrapper.get()",
    "String SimpleTbCacheValueWrapper.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    SimpleTbCacheValueWrapper<Object> emptyResult = SimpleTbCacheValueWrapper.empty();

    // Act
    String actualToStringResult = emptyResult.toString();

    // Assert
    assertEquals("SimpleTbCacheValueWrapper(value=null)", actualToStringResult);
    assertNull(emptyResult.get());
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#empty()}.
   *
   * <p>Method under test: {@link SimpleTbCacheValueWrapper#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleTbCacheValueWrapper SimpleTbCacheValueWrapper.empty()"})
  void testEmpty() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualEmptyResult = SimpleTbCacheValueWrapper.empty();

    // Assert
    assertNull(actualEmptyResult.get());
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)} with {@code source}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link ValueWrapper} {@link ValueWrapper#get()} return {@code Get}.
   *   <li>Then return {@link SimpleTbCacheValueWrapper#get()} is {@code Get}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)}
   */
  @Test
  @DisplayName(
      "Test wrap(ValueWrapper) with 'source'; given 'Get'; when ValueWrapper get() return 'Get'; then return get() is 'Get'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleTbCacheValueWrapper SimpleTbCacheValueWrapper.wrap(ValueWrapper)"})
  void testWrapWithSource_givenGet_whenValueWrapperGetReturnGet_thenReturnGetIsGet() {
    // Arrange
    ValueWrapper source = mock(ValueWrapper.class);
    when(source.get()).thenReturn("Get");

    // Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap(source);

    // Assert
    verify(source).get();
    assertEquals("Get", actualWrapResult.get());
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)} with {@code source}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link ValueWrapper} {@link ValueWrapper#get()} return {@code Get}.
   *   <li>Then return {@link SimpleTbCacheValueWrapper#get()} is {@code Get}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)}
   */
  @Test
  @DisplayName(
      "Test wrap(ValueWrapper) with 'source'; given 'Get'; when ValueWrapper get() return 'Get'; then return get() is 'Get'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleTbCacheValueWrapper SimpleTbCacheValueWrapper.wrap(ValueWrapper)"})
  void testWrapWithSource_givenGet_whenValueWrapperGetReturnGet_thenReturnGetIsGet2() {
    // Arrange
    ValueWrapper source = mock(ValueWrapper.class);
    when(source.get()).thenReturn("Get");

    // Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap(source);
    Object actualGetResult = actualWrapResult.get();

    // Assert
    verify(source).get();
    assertEquals("Get", actualGetResult);
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)}
   */
  @Test
  @DisplayName("Test wrap(ValueWrapper) with 'source'; when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleTbCacheValueWrapper SimpleTbCacheValueWrapper.wrap(ValueWrapper)"})
  void testWrapWithSource_whenNull_thenNull() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult =
        SimpleTbCacheValueWrapper.wrap((ValueWrapper) null);

    // Assert
    assertNull(null);
    assertNull(actualWrapResult);
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#wrap(Object)} with {@code value}.
   *
   * <p>Method under test: {@link SimpleTbCacheValueWrapper#wrap(Object)}
   */
  @Test
  @DisplayName("Test wrap(Object) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleTbCacheValueWrapper SimpleTbCacheValueWrapper.wrap(Object)"})
  void testWrapWithValue() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap("Value");

    // Assert
    assertEquals("Value", actualWrapResult.get());
  }
}
