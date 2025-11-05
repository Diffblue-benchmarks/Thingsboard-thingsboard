package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

class ThingsboardSecurityConfigurationDiffblueTest {
  /**
   * Test {@link ThingsboardSecurityConfiguration#buildEtagFilter()}.
   *
   * <p>Method under test: {@link ThingsboardSecurityConfiguration#buildEtagFilter()}
   */
  @Test
  @DisplayName("Test buildEtagFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterRegistrationBean ThingsboardSecurityConfiguration.buildEtagFilter()"})
  void testBuildEtagFilter() throws Exception {
    // Arrange and Act
    FilterRegistrationBean<ShallowEtagHeaderFilter> actualBuildEtagFilterResult =
        new ThingsboardSecurityConfiguration().buildEtagFilter();

    // Assert
    Collection<String> servletNames = actualBuildEtagFilterResult.getServletNames();
    assertTrue(servletNames instanceof Set);
    Collection<ServletRegistrationBean<?>> servletRegistrationBeans =
        actualBuildEtagFilterResult.getServletRegistrationBeans();
    assertTrue(servletRegistrationBeans instanceof Set);
    Collection<String> urlPatterns = actualBuildEtagFilterResult.getUrlPatterns();
    assertEquals(5, urlPatterns.size());
    assertTrue(urlPatterns instanceof Set);
    assertEquals("etagFilter", actualBuildEtagFilterResult.getFilterName());
    assertFalse(actualBuildEtagFilterResult.isMatchAfter());
    assertTrue(servletNames.isEmpty());
    assertTrue(servletRegistrationBeans.isEmpty());
    assertTrue(actualBuildEtagFilterResult.getInitParameters().isEmpty());
    assertTrue(actualBuildEtagFilterResult.isAsyncSupported());
    assertTrue(actualBuildEtagFilterResult.isEnabled());
    assertEquals(Integer.MAX_VALUE, actualBuildEtagFilterResult.getOrder());
  }
}
