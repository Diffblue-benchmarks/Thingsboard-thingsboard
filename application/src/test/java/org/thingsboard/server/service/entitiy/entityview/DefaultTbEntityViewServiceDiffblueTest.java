package org.thingsboard.server.service.entitiy.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
class DefaultTbEntityViewServiceDiffblueTest {
  /**
   * Test {@link DefaultTbEntityViewService#toException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code foo}.
   *   <li>Then return LocalizedMessage is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbEntityViewService#toException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test toException(Throwable); when IOException(String) with 'foo'; then return LocalizedMessage is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception DefaultTbEntityViewService.toException(Throwable)"})
  void testToException_whenIOExceptionWithFoo_thenReturnLocalizedMessageIsFoo() {
    // Arrange and Act
    Exception actualToExceptionResult =
        DefaultTbEntityViewService.toException(new IOException("foo"));

    // Assert
    assertEquals("foo", actualToExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualToExceptionResult.getMessage());
    assertNull(actualToExceptionResult.getCause());
    assertEquals(0, actualToExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link DefaultTbEntityViewService#toException(Throwable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbEntityViewService#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception DefaultTbEntityViewService.toException(Throwable)"})
  void testToException_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DefaultTbEntityViewService.toException(null));
  }

  /**
   * Test {@link DefaultTbEntityViewService#toException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return LocalizedMessage is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbEntityViewService#toException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test toException(Throwable); when Throwable(); then return LocalizedMessage is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception DefaultTbEntityViewService.toException(Throwable)"})
  void testToException_whenThrowable_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    Exception actualToExceptionResult = DefaultTbEntityViewService.toException(error);

    // Assert
    assertEquals("java.lang.Throwable", actualToExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualToExceptionResult.getMessage());
    assertSame(error, actualToExceptionResult.getCause());
  }
}
