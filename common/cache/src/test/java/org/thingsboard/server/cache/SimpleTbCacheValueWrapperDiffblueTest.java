package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.Cache;

class SimpleTbCacheValueWrapperDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleTbCacheValueWrapper#toString()}
   *   <li>{@link SimpleTbCacheValueWrapper#get()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * <p>
   * Method under test: {@link SimpleTbCacheValueWrapper#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  void testEmpty() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualEmptyResult = SimpleTbCacheValueWrapper.empty();

    // Assert
    assertNull(actualEmptyResult.get());
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#wrap(ValueWrapper)} with
   * {@code source}.
   * <p>
   * Method under test: {@link SimpleTbCacheValueWrapper#wrap(Cache.ValueWrapper)}
   */
  @Test
  @DisplayName("Test wrap(ValueWrapper) with 'source'")
  void testWrapWithSource() {
    // Arrange
    Cache.ValueWrapper source = mock(Cache.ValueWrapper.class);
    when(source.get()).thenReturn("Get");

    // Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap(source);
    Object actualGetResult = actualWrapResult.get();

    // Assert
    verify(source).get();
    assertEquals("Get", actualGetResult);
  }

  /**
   * Test {@link SimpleTbCacheValueWrapper#wrap(Object)} with {@code value}.
   * <p>
   * Method under test: {@link SimpleTbCacheValueWrapper#wrap(Object)}
   */
  @Test
  @DisplayName("Test wrap(Object) with 'value'")
  void testWrapWithValue() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap("Value");

    // Assert
    assertEquals("Value", actualWrapResult.get());
  }
}
