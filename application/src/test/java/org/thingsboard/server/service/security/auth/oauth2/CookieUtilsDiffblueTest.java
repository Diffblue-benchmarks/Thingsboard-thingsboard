package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.partitions.model.Endpoint;
import com.amazonaws.partitions.model.Service;
import com.amazonaws.util.EC2MetadataUtils;
import com.amazonaws.util.EC2MetadataUtils.InstanceInfo;
import com.datastax.dse.driver.internal.core.insights.schema.AuthProviderType;
import com.datastax.dse.driver.internal.core.insights.schema.Insight;
import com.datastax.dse.driver.internal.core.insights.schema.InsightMetadata;
import com.datastax.dse.driver.internal.core.insights.schema.InsightType;
import com.datastax.dse.driver.internal.core.insights.schema.InsightsPlatformInfo;
import com.datastax.dse.driver.internal.core.insights.schema.InsightsPlatformInfo.CPUS;
import com.datastax.dse.driver.internal.core.insights.schema.InsightsPlatformInfo.OS;
import com.datastax.dse.driver.internal.core.insights.schema.InsightsPlatformInfo.RuntimeAndCompileTimeVersions;
import com.datastax.dse.driver.internal.core.insights.schema.InsightsStartupData;
import com.datastax.dse.driver.internal.core.insights.schema.InsightsStartupData.Builder;
import com.datastax.dse.driver.internal.core.insights.schema.PoolSizeByHostDistance;
import com.datastax.dse.driver.internal.core.insights.schema.ReconnectionPolicyInfo;
import com.datastax.dse.driver.internal.core.insights.schema.SSL;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockCookie;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class CookieUtilsDiffblueTest {
  /**
   * Test {@link CookieUtils#getCookie(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#getCookie(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test getCookie(HttpServletRequest, String); when MockHttpServletRequest(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CookieUtils.getCookie(HttpServletRequest, String)"})
  void testGetCookie_whenMockHttpServletRequest_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Cookie> actualCookie = CookieUtils.getCookie(new MockHttpServletRequest(), "Name");

    // Assert
    assertFalse(actualCookie.isPresent());
  }

  /**
   * Test {@link CookieUtils#addCookie(HttpServletResponse, String, String, int)}.
   * <ul>
   *   <li>Then calls {@link HttpServletResponseWrapper#addCookie(Cookie)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#addCookie(HttpServletResponse, String, String, int)}
   */
  @Test
  @DisplayName("Test addCookie(HttpServletResponse, String, String, int); then calls addCookie(Cookie)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CookieUtils.addCookie(HttpServletResponse, String, String, int)"})
  void testAddCookie_thenCallsAddCookie() {
    // Arrange
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    doNothing().when(response).addCookie(Mockito.<Cookie>any());

    // Act
    CookieUtils.addCookie(response, "Name", "42", 3);

    // Assert
    verify(response).addCookie(isA(Cookie.class));
  }

  /**
   * Test {@link CookieUtils#addCookie(HttpServletResponse, String, String, int)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#addCookie(HttpServletResponse, String, String, int)}
   */
  @Test
  @DisplayName("Test addCookie(HttpServletResponse, String, String, int); then MockHttpServletResponse (default constructor) HeaderNames size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CookieUtils.addCookie(HttpServletResponse, String, String, int)"})
  void testAddCookie_thenMockHttpServletResponseHeaderNamesSizeIsOne() {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    CookieUtils.addCookie(response, "Name", "42", 3);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    Cookie[] cookies = response.getCookies();
    Cookie cookie = cookies[0];
    assertEquals("/", cookie.getPath());
    assertEquals("42", cookie.getValue());
    assertEquals("Name", cookie.getName());
    assertNull(cookie.getComment());
    assertNull(cookie.getDomain());
    assertEquals(0, cookie.getVersion());
    assertEquals(1, cookies.length);
    assertEquals(3, cookie.getMaxAge());
    Map<String, String> attributes = cookie.getAttributes();
    assertEquals(3, attributes.size());
    assertFalse(cookie.getSecure());
    assertTrue(headerNames.contains("Set-Cookie"));
    assertTrue(attributes.containsKey("HttpOnly"));
    assertTrue(attributes.containsKey("Max-Age"));
    assertTrue(attributes.containsKey("Path"));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize() {
    // Arrange, Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnV0aWwuRUMyTWV0YWRhdGFVdGlscyRJbnN0YW5jZUluZm8iLCJwZW5kaW5nVGltZSI6"
            + "IlBlbmRpbmcgVGltZSIsImluc3RhbmNlVHlwZSI6Ikluc3RhbmNlIFR5cGUiLCJpbWFnZUlkIjoiNDIiLCJpbnN0YW5jZUlkIjoi"
            + "NDIiLCJiaWxsaW5nUHJvZHVjdHMiOlsiQmlsbGluZyBQcm9kdWN0cyJdLCJhcmNoaXRlY3R1cmUiOiJBcmNoaXRlY3R1cmUiLCJh"
            + "Y2NvdW50SWQiOiI0MiIsImtlcm5lbElkIjoiNDIiLCJyYW1kaXNrSWQiOiI0MiIsInJlZ2lvbiI6InVzLWVhc3QtMiIsInZlcnNp"
            + "b24iOiIxLjAuMiIsImF2YWlsYWJpbGl0eVpvbmUiOiJBdmFpbGFiaWxpdHkgWm9uZSIsInByaXZhdGVJcCI6IlByaXZhdGUgSXAi"
            + "LCJkZXZwYXlQcm9kdWN0Q29kZXMiOlsiRGV2cGF5IFByb2R1Y3QgQ29kZXMiXX0=",
        CookieUtils.serialize(new InstanceInfo("Pending Time", "Instance Type", "42", "42",
            new String[]{"Billing Products"}, "Architecture", "42", "42", "42", "us-east-2", "1.0.2",
            "Availability Zone", "Private Ip", new String[]{"Devpay Product Codes"})));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize2() {
    // Arrange, Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0TWV0"
            + "YWRhdGEiLCJuYW1lIjoiTmFtZSIsInRpbWVzdGFtcCI6MTAsInRhZ3MiOnsiQGNsYXNzIjoiamF2YS51dGlsLkhhc2hNYXAifSwi"
            + "aW5zaWdodFR5cGUiOiJFVkVOVCIsImluc2lnaHRNYXBwaW5nSWQiOiI0MiJ9",
        CookieUtils.serialize(new InsightMetadata("Name", 10L, new HashMap<>(), InsightType.EVENT, "42")));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize3() {
    // Arrange
    Builder withApplicationVersionResult = InsightsStartupData.builder()
        .withApplicationName("Application Name")
        .withApplicationNameWasGenerated(true)
        .withApplicationVersion("1.0.2");
    Builder withCompressionResult = withApplicationVersionResult
        .withAuthProvider(new AuthProviderType("Type", "Namespace"))
        .withClientId("42")
        .withCompression("Compression");
    Builder withConfigAntiPatternsResult = withCompressionResult.withConfigAntiPatterns(new HashMap<>());
    Builder withContactPointsResult = withConfigAntiPatternsResult.withContactPoints(new HashMap<>());
    Builder withDriverVersionResult = withContactPointsResult.withDataCenters(new HashSet<>())
        .withDriverName("Driver Name")
        .withDriverVersion("1.0.2");
    Builder withLocalAddressResult = withDriverVersionResult.withExecutionProfiles(new HashMap<>())
        .withHeartbeatInterval(42L)
        .withHostName("Host Name")
        .withInitialControlConnection("42 Main St")
        .withLocalAddress("42 Main St");
    Builder withPeriodicStatusIntervalResult = withLocalAddressResult.withOtherOptions(new HashMap<>())
        .withPeriodicStatusInterval(42L);
    OS os = new OS("Name", "1.0.2", "Arch");

    CPUS cpus = new CPUS(3, "Model");

    Builder withPlatformInfoResult = withPeriodicStatusIntervalResult
        .withPlatformInfo(new InsightsPlatformInfo(os, cpus, new HashMap<>()));
    Builder withProtocolVersionResult = withPlatformInfoResult
        .withPoolSizeByHostDistance(new PoolSizeByHostDistance(1, 1, 1))
        .withProtocolVersion(1);
    Builder withSessionIdResult = withProtocolVersionResult
        .withReconnectionPolicy(new ReconnectionPolicyInfo("Type", new HashMap<>(), "Namespace"))
        .withSessionId("42");
    InsightsStartupData buildResult = withSessionIdResult.withSsl(new SSL(true, true)).build();

    // Act and Assert
    assertEquals("eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0c1N0"
        + "YXJ0dXBEYXRhIiwiY2xpZW50SWQiOiI0MiIsInNlc3Npb25JZCI6IjQyIiwiYXBwbGljYXRpb25OYW1lIjoiQXBwbGljYXRpb24g"
        + "TmFtZSIsImFwcGxpY2F0aW9uVmVyc2lvbiI6IjEuMC4yIiwiY29udGFjdFBvaW50cyI6eyJAY2xhc3MiOiJqYXZhLnV0aWwuSGFz"
        + "aE1hcCJ9LCJpbml0aWFsQ29udHJvbENvbm5lY3Rpb24iOiI0MiBNYWluIFN0IiwicHJvdG9jb2xWZXJzaW9uIjoxLCJsb2NhbEFk"
        + "ZHJlc3MiOiI0MiBNYWluIFN0IiwiZXhlY3V0aW9uUHJvZmlsZXMiOnsiQGNsYXNzIjoiamF2YS51dGlsLkhhc2hNYXAifSwicG9v"
        + "bFNpemVCeUhvc3REaXN0YW5jZSI6eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2ln"
        + "aHRzLnNjaGVtYS5Qb29sU2l6ZUJ5SG9zdERpc3RhbmNlIiwibG9jYWwiOjEsInJlbW90ZSI6MSwiaWdub3JlZCI6MX0sImhlYXJ0"
        + "YmVhdEludGVydmFsIjo0MiwiY29tcHJlc3Npb24iOiJDb21wcmVzc2lvbiIsInJlY29ubmVjdGlvblBvbGljeSI6eyJAY2xhc3Mi"
        + "OiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5SZWNvbm5lY3Rpb25Qb2xpY3lJ"
        + "bmZvIiwidHlwZSI6IlR5cGUiLCJvcHRpb25zIjp7IkBjbGFzcyI6ImphdmEudXRpbC5IYXNoTWFwIn0sIm5hbWVzcGFjZSI6Ik5h"
        + "bWVzcGFjZSJ9LCJzc2wiOnsiQGNsYXNzIjoiY29tLmRhdGFzdGF4LmRzZS5kcml2ZXIuaW50ZXJuYWwuY29yZS5pbnNpZ2h0cy5z"
        + "Y2hlbWEuU1NMIiwiZW5hYmxlZCI6dHJ1ZSwiY2VydFZhbGlkYXRpb24iOnRydWV9LCJhdXRoUHJvdmlkZXIiOnsiQGNsYXNzIjoi"
        + "Y29tLmRhdGFzdGF4LmRzZS5kcml2ZXIuaW50ZXJuYWwuY29yZS5pbnNpZ2h0cy5zY2hlbWEuQXV0aFByb3ZpZGVyVHlwZSIsInR5"
        + "cGUiOiJUeXBlIiwibmFtZXNwYWNlIjoiTmFtZXNwYWNlIn0sIm90aGVyT3B0aW9ucyI6eyJAY2xhc3MiOiJqYXZhLnV0aWwuSGFz"
        + "aE1hcCJ9LCJjb25maWdBbnRpUGF0dGVybnMiOnsiQGNsYXNzIjoiamF2YS51dGlsLkhhc2hNYXAifSwicGVyaW9kaWNTdGF0dXNJ"
        + "bnRlcnZhbCI6NDIsInBsYXRmb3JtSW5mbyI6eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3Jl"
        + "Lmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0c1BsYXRmb3JtSW5mbyIsIm9zIjp7IkBjbGFzcyI6ImNvbS5kYXRhc3RheC5kc2UuZHJp"
        + "dmVyLmludGVybmFsLmNvcmUuaW5zaWdodHMuc2NoZW1hLkluc2lnaHRzUGxhdGZvcm1JbmZvJE9TIiwibmFtZSI6Ik5hbWUiLCJ2"
        + "ZXJzaW9uIjoiMS4wLjIiLCJhcmNoIjoiQXJjaCJ9LCJjcHVzIjp7IkBjbGFzcyI6ImNvbS5kYXRhc3RheC5kc2UuZHJpdmVyLmlu"
        + "dGVybmFsLmNvcmUuaW5zaWdodHMuc2NoZW1hLkluc2lnaHRzUGxhdGZvcm1JbmZvJENQVVMiLCJsZW5ndGgiOjMsIm1vZGVsIjoi"
        + "TW9kZWwifSwicnVudGltZSI6eyJAY2xhc3MiOiJqYXZhLnV0aWwuSGFzaE1hcCJ9fSwiaG9zdE5hbWUiOiJIb3N0IE5hbWUiLCJk"
        + "cml2ZXJOYW1lIjoiRHJpdmVyIE5hbWUiLCJhcHBsaWNhdGlvbk5hbWVXYXNHZW5lcmF0ZWQiOnRydWUsImRyaXZlclZlcnNpb24i"
        + "OiIxLjAuMiIsImRhdGFDZW50ZXJzIjpbImphdmEudXRpbC5IYXNoU2V0IixbXV19", CookieUtils.serialize(buildResult));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link HashMap#HashMap()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); given 'foo'; when HashMap() 'foo' is HashMap(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_givenFoo_whenHashMapFooIsHashMap_thenReturnAString() {
    // Arrange
    HashMap<String, Map<String, RuntimeAndCompileTimeVersions>> runtime = new HashMap<>();
    runtime.put("foo", new HashMap<>());
    OS os = new OS("Name", "1.0.2", "Arch");

    // Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0c1Bs"
            + "YXRmb3JtSW5mbyIsIm9zIjp7IkBjbGFzcyI6ImNvbS5kYXRhc3RheC5kc2UuZHJpdmVyLmludGVybmFsLmNvcmUuaW5zaWdodHMu"
            + "c2NoZW1hLkluc2lnaHRzUGxhdGZvcm1JbmZvJE9TIiwibmFtZSI6Ik5hbWUiLCJ2ZXJzaW9uIjoiMS4wLjIiLCJhcmNoIjoiQXJj"
            + "aCJ9LCJjcHVzIjp7IkBjbGFzcyI6ImNvbS5kYXRhc3RheC5kc2UuZHJpdmVyLmludGVybmFsLmNvcmUuaW5zaWdodHMuc2NoZW1h"
            + "Lkluc2lnaHRzUGxhdGZvcm1JbmZvJENQVVMiLCJsZW5ndGgiOjMsIm1vZGVsIjoiTW9kZWwifSwicnVudGltZSI6eyJAY2xhc3Mi"
            + "OiJqYXZhLnV0aWwuSGFzaE1hcCIsImZvbyI6eyJAY2xhc3MiOiJqYXZhLnV0aWwuSGFzaE1hcCJ9fX0=",
        CookieUtils.serialize(new InsightsPlatformInfo(os, new CPUS(3, "Model"), runtime)));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link Endpoint} (default constructor).</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when Endpoint (default constructor); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenEndpoint_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnBhcnRpdGlvbnMubW9kZWwuRW5kcG9pbnQiLCJob3N0bmFtZSI6bnVsbCwiY3JlZGV"
        + "udGlhbFNjb3BlIjpudWxsLCJwcm90b2NvbHMiOm51bGwsInNpZ25hdHVyZVZlcnNpb25zIjpudWxsLCJzc2xDb21tb25OYW1lIjpudWxsfQ"
        + "==", CookieUtils.serialize(new Endpoint()));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code NDI=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when forty-two; then return 'NDI='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenFortyTwo_thenReturnNdi() {
    // Arrange, Act and Assert
    assertEquals("NDI=", CookieUtils.serialize(42));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link Insight#Insight(InsightMetadata, Object)} with metadata is {@link InsightMetadata#InsightMetadata(String, long, Map, InsightType, String)} and {@code Data}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when Insight(InsightMetadata, Object) with metadata is InsightMetadata(String, long, Map, InsightType, String) and 'Data'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenInsightWithMetadataIsInsightMetadataAndData_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0Iiwi"
            + "bWV0YWRhdGEiOnsiQGNsYXNzIjoiY29tLmRhdGFzdGF4LmRzZS5kcml2ZXIuaW50ZXJuYWwuY29yZS5pbnNpZ2h0cy5zY2hlbWEu"
            + "SW5zaWdodE1ldGFkYXRhIiwibmFtZSI6Ik5hbWUiLCJ0aW1lc3RhbXAiOjEwLCJ0YWdzIjp7IkBjbGFzcyI6ImphdmEudXRpbC5I"
            + "YXNoTWFwIn0sImluc2lnaHRUeXBlIjoiRVZFTlQiLCJpbnNpZ2h0TWFwcGluZ0lkIjoiNDIifSwiZGF0YSI6IkRhdGEifQ==",
        CookieUtils.serialize(
            new Insight<>(new InsightMetadata("Name", 10L, new HashMap<>(), InsightType.EVENT, "42"), "Data")));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link Insight#Insight(InsightMetadata, Object)} with metadata is {@code null} and {@code Data}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when Insight(InsightMetadata, Object) with metadata is 'null' and 'Data'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenInsightWithMetadataIsNullAndData_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals("eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0Iiwi"
        + "ZGF0YSI6IkRhdGEifQ==", CookieUtils.serialize(new Insight<>(null, "Data")));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link InsightsPlatformInfo#InsightsPlatformInfo(OS, CPUS, Map)} with os is {@link InsightsPlatformInfo.OS#OS(String, String, String)} and cpus is {@link CPUS#CPUS(int, String)} and runtime is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when InsightsPlatformInfo(OS, CPUS, Map) with os is OS(String, String, String) and cpus is CPUS(int, String) and runtime is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenInsightsPlatformInfoWithOsIsOsAndCpusIsCpusAndRuntimeIsHashMap() {
    // Arrange
    OS os = new OS("Name", "1.0.2", "Arch");

    CPUS cpus = new CPUS(3, "Model");

    // Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uZGF0YXN0YXguZHNlLmRyaXZlci5pbnRlcm5hbC5jb3JlLmluc2lnaHRzLnNjaGVtYS5JbnNpZ2h0c1Bs"
            + "YXRmb3JtSW5mbyIsIm9zIjp7IkBjbGFzcyI6ImNvbS5kYXRhc3RheC5kc2UuZHJpdmVyLmludGVybmFsLmNvcmUuaW5zaWdodHMu"
            + "c2NoZW1hLkluc2lnaHRzUGxhdGZvcm1JbmZvJE9TIiwibmFtZSI6Ik5hbWUiLCJ2ZXJzaW9uIjoiMS4wLjIiLCJhcmNoIjoiQXJj"
            + "aCJ9LCJjcHVzIjp7IkBjbGFzcyI6ImNvbS5kYXRhc3RheC5kc2UuZHJpdmVyLmludGVybmFsLmNvcmUuaW5zaWdodHMuc2NoZW1h"
            + "Lkluc2lnaHRzUGxhdGZvcm1JbmZvJENQVVMiLCJsZW5ndGgiOjMsIm1vZGVsIjoiTW9kZWwifSwicnVudGltZSI6eyJAY2xhc3Mi"
            + "OiJqYXZhLnV0aWwuSGFzaE1hcCJ9fQ==",
        CookieUtils.serialize(new InsightsPlatformInfo(os, cpus, new HashMap<>())));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code bnVsbA==}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when 'null'; then return 'bnVsbA=='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenNull_thenReturnBnVsbA() {
    // Arrange, Act and Assert
    assertEquals("bnVsbA==", CookieUtils.serialize(null));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code Ik9iamVjdCI=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when 'Object'; then return 'Ik9iamVjdCI='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenObject_thenReturnIk9iamVjdCI() {
    // Arrange, Act and Assert
    assertEquals("Ik9iamVjdCI=", CookieUtils.serialize("Object"));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code MQ==}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when one; then return 'MQ=='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenOne_thenReturnMq() {
    // Arrange, Act and Assert
    assertEquals("MQ==", CookieUtils.serialize(1));
  }

  /**
   * Test {@link CookieUtils#serialize(Object)}.
   * <ul>
   *   <li>When {@link Service#Service(Map)} with endpoints is {@link HashMap#HashMap()}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#serialize(Object)}
   */
  @Test
  @DisplayName("Test serialize(Object); when Service(Map) with endpoints is HashMap(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CookieUtils.serialize(Object)"})
  void testSerialize_whenServiceWithEndpointsIsHashMap_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "eyJAY2xhc3MiOiJjb20uYW1hem9uYXdzLnBhcnRpdGlvbnMubW9kZWwuU2VydmljZSIsImVuZHBvaW50cyI6eyJAY2xhc3MiOiJq"
            + "YXZhLnV0aWwuSGFzaE1hcCJ9LCJkZWZhdWx0cyI6bnVsbCwicGFydGl0aW9uV2lkZUVuZHBvaW50QXZhaWxhYmxlIjpmYWxzZSwi"
            + "cGFydGl0aW9uRW5kcG9pbnQiOm51bGwsImlzUmVnaW9uYWxpemVkIjpmYWxzZX0=",
        CookieUtils.serialize(new Service(new HashMap<>())));
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link Cookie} {@link Cookie#getValue()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); given empty string; when Cookie getValue() return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CookieUtils.deserialize(Cookie, Class)"})
  void testDeserialize_givenEmptyString_whenCookieGetValueReturnEmptyString() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("");
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link Cookie} {@link Cookie#getValue()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); given empty string; when Cookie getValue() return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CookieUtils.deserialize(Cookie, Class)"})
  void testDeserialize_givenEmptyString_whenCookieGetValueReturnEmptyString2() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("");
    Class<CookieUtils> cls = CookieUtils.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Cookie} {@link Cookie#getValue()} return {@code foo}.</li>
   *   <li>Then calls {@link Cookie#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); given 'foo'; when Cookie getValue() return 'foo'; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CookieUtils.deserialize(Cookie, Class)"})
  void testDeserialize_givenFoo_whenCookieGetValueReturnFoo_thenCallsGetValue() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("foo");
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>When {@link MockCookie#MockCookie(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); when MockCookie(String, String) with 'Name' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CookieUtils.deserialize(Cookie, Class)"})
  void testDeserialize_whenMockCookieWithNameAndValueIs42() {
    // Arrange
    MockCookie cookie = new MockCookie("Name", "42");

    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
  }

  /**
   * Test {@link CookieUtils#deserialize(Cookie, Class)}.
   * <ul>
   *   <li>When {@code CookieUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieUtils#deserialize(Cookie, Class)}
   */
  @Test
  @DisplayName("Test deserialize(Cookie, Class); when 'org.thingsboard.server.service.security.auth.oauth2.CookieUtils'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CookieUtils.deserialize(Cookie, Class)"})
  void testDeserialize_whenOrgThingsboardServerServiceSecurityAuthOauth2CookieUtils() {
    // Arrange
    Cookie cookie = mock(Cookie.class);
    when(cookie.getValue()).thenReturn("foo");
    Class<CookieUtils> cls = CookieUtils.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CookieUtils.deserialize(cookie, cls));
    verify(cookie).getValue();
  }
}
