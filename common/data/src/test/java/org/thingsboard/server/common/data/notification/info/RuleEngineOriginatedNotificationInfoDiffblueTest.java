package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.RuleEngineOriginatedNotificationInfo.RuleEngineOriginatedNotificationInfoBuilder;

@ContextConfiguration(classes = {RuleEngineOriginatedNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleEngineOriginatedNotificationInfoDiffblueTest {
  @Autowired
  private RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder;

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return {@code customerId} is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'customerId' is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RuleEngineOriginatedNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnCustomerIdIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(4, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("originatorId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateData.get("customerId"));
    assertEquals("Msg Type", actualTemplateData.get("msgType"));
    assertEquals("Tenant", actualTemplateData.get("originatorType"));
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return {@code customerId} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'customerId' is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RuleEngineOriginatedNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnCustomerIdIsEmptyString() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    buildResult.setMsgCustomerId(null);

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(4, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("customerId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("originatorId"));
    assertEquals("Msg Type", actualTemplateData.get("msgType"));
    assertEquals("Tenant", actualTemplateData.get("originatorType"));
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link RuleEngineOriginatedNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder builderResult2 = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = builderResult2
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link RuleEngineOriginatedNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder2
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link RuleEngineOriginatedNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(null)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfoBuilder msgMetadataResult = msgDataResult.msgMetadata(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgMetadataResult
        .msgOriginator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgData(Mockito.<Map<String, String>>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder);
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder2
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder3 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder3.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder3
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgMetadata(Mockito.<Map<String, String>>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgData(Mockito.<Map<String, String>>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder);
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder3 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder3.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder2);
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder3
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder4 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder4.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder4
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgMetadata(Mockito.<Map<String, String>>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgData(Mockito.<Map<String, String>>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder);
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder3 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder3.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder2);
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder3
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType(null)
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder4 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder4.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder4
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgMetadata(Mockito.<Map<String, String>>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgData(Mockito.<Map<String, String>>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder);
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder3 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder3.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder2);
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder3
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("42")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder4 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder4.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder4
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    builderResult.msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgMetadata(Mockito.<Map<String, String>>any()))
        .thenReturn(builderResult);
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgData(Mockito.<Map<String, String>>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder);
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder3 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder3.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder2);
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder3
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder4 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder4.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder4
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder.msgMetadata(Mockito.<Map<String, String>>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder2 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder2.msgData(Mockito.<Map<String, String>>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder);
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder3 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder3.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(ruleEngineOriginatedNotificationInfoBuilder2);
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = ruleEngineOriginatedNotificationInfoBuilder3
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType(null)
        .build();
    RuleEngineOriginatedNotificationInfoBuilder ruleEngineOriginatedNotificationInfoBuilder4 = mock(
        RuleEngineOriginatedNotificationInfoBuilder.class);
    when(ruleEngineOriginatedNotificationInfoBuilder4.msgCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(RuleEngineOriginatedNotificationInfo.builder());
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 = ruleEngineOriginatedNotificationInfoBuilder4
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 = msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult2 = msgDataResult2.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
      "int RuleEngineOriginatedNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult
        .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo buildResult = msgDataResult.msgMetadata(new HashMap<>())
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleEngineOriginatedNotificationInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#RuleEngineOriginatedNotificationInfo()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgCustomerId(CustomerId)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgData(Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgMetadata(Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgOriginator(EntityId)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgType(String)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#toString()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgCustomerId()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgData()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgMetadata()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgOriginator()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgType()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getStateEntityId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineOriginatedNotificationInfo.<init>()",
      "void RuleEngineOriginatedNotificationInfo.<init>(EntityId, CustomerId, String, Map, Map)",
      "CustomerId RuleEngineOriginatedNotificationInfo.getAffectedCustomerId()",
      "CustomerId RuleEngineOriginatedNotificationInfo.getMsgCustomerId()",
      "Map RuleEngineOriginatedNotificationInfo.getMsgData()",
      "Map RuleEngineOriginatedNotificationInfo.getMsgMetadata()",
      "EntityId RuleEngineOriginatedNotificationInfo.getMsgOriginator()",
      "String RuleEngineOriginatedNotificationInfo.getMsgType()",
      "EntityId RuleEngineOriginatedNotificationInfo.getStateEntityId()",
      "void RuleEngineOriginatedNotificationInfo.setMsgCustomerId(CustomerId)",
      "void RuleEngineOriginatedNotificationInfo.setMsgData(Map)",
      "void RuleEngineOriginatedNotificationInfo.setMsgMetadata(Map)",
      "void RuleEngineOriginatedNotificationInfo.setMsgOriginator(EntityId)",
      "void RuleEngineOriginatedNotificationInfo.setMsgType(String)",
      "String RuleEngineOriginatedNotificationInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    RuleEngineOriginatedNotificationInfo actualRuleEngineOriginatedNotificationInfo = new RuleEngineOriginatedNotificationInfo();
    CustomerId msgCustomerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleEngineOriginatedNotificationInfo.setMsgCustomerId(msgCustomerId);
    HashMap<String, String> msgData = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgData(msgData);
    HashMap<String, String> msgMetadata = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgMetadata(msgMetadata);
    actualRuleEngineOriginatedNotificationInfo.setMsgOriginator(TenantId.SYS_TENANT_ID);
    actualRuleEngineOriginatedNotificationInfo.setMsgType("Msg Type");
    String actualToStringResult = actualRuleEngineOriginatedNotificationInfo.toString();
    CustomerId actualAffectedCustomerId = actualRuleEngineOriginatedNotificationInfo.getAffectedCustomerId();
    CustomerId actualMsgCustomerId = actualRuleEngineOriginatedNotificationInfo.getMsgCustomerId();
    Map<String, String> actualMsgData = actualRuleEngineOriginatedNotificationInfo.getMsgData();
    Map<String, String> actualMsgMetadata = actualRuleEngineOriginatedNotificationInfo.getMsgMetadata();
    EntityId actualMsgOriginator = actualRuleEngineOriginatedNotificationInfo.getMsgOriginator();
    String actualMsgType = actualRuleEngineOriginatedNotificationInfo.getMsgType();
    EntityId actualStateEntityId = actualRuleEngineOriginatedNotificationInfo.getStateEntityId();

    // Assert
    assertEquals("Msg Type", actualMsgType);
    assertEquals(
        "RuleEngineOriginatedNotificationInfo(msgOriginator=13814000-1dd2-11b2-8080-808080808080, msgCustomerId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9, msgType=Msg Type, msgMetadata={}, msgData={})",
        actualToStringResult);
    assertTrue(actualMsgData.isEmpty());
    assertTrue(actualMsgMetadata.isEmpty());
    assertSame(msgData, actualMsgData);
    assertSame(msgMetadata, actualMsgMetadata);
    assertSame(msgCustomerId, actualAffectedCustomerId);
    assertSame(msgCustomerId, actualMsgCustomerId);
    TenantId tenantId = ((TenantId) actualStateEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualMsgOriginator);
    assertSame(tenantId, actualStateEntityId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#RuleEngineOriginatedNotificationInfo(EntityId, CustomerId, String, Map, Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgCustomerId(CustomerId)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgData(Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgMetadata(Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgOriginator(EntityId)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#setMsgType(String)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#toString()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgCustomerId()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgData()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgMetadata()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgOriginator()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getMsgType()}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#getStateEntityId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineOriginatedNotificationInfo.<init>()",
      "void RuleEngineOriginatedNotificationInfo.<init>(EntityId, CustomerId, String, Map, Map)",
      "CustomerId RuleEngineOriginatedNotificationInfo.getAffectedCustomerId()",
      "CustomerId RuleEngineOriginatedNotificationInfo.getMsgCustomerId()",
      "Map RuleEngineOriginatedNotificationInfo.getMsgData()",
      "Map RuleEngineOriginatedNotificationInfo.getMsgMetadata()",
      "EntityId RuleEngineOriginatedNotificationInfo.getMsgOriginator()",
      "String RuleEngineOriginatedNotificationInfo.getMsgType()",
      "EntityId RuleEngineOriginatedNotificationInfo.getStateEntityId()",
      "void RuleEngineOriginatedNotificationInfo.setMsgCustomerId(CustomerId)",
      "void RuleEngineOriginatedNotificationInfo.setMsgData(Map)",
      "void RuleEngineOriginatedNotificationInfo.setMsgMetadata(Map)",
      "void RuleEngineOriginatedNotificationInfo.setMsgOriginator(EntityId)",
      "void RuleEngineOriginatedNotificationInfo.setMsgType(String)",
      "String RuleEngineOriginatedNotificationInfo.toString()"})
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange
    CustomerId msgCustomerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashMap<String, String> msgMetadata = new HashMap<>();

    // Act
    RuleEngineOriginatedNotificationInfo actualRuleEngineOriginatedNotificationInfo = new RuleEngineOriginatedNotificationInfo(
        TenantId.SYS_TENANT_ID, msgCustomerId, "Msg Type", msgMetadata, new HashMap<>());
    CustomerId msgCustomerId2 = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleEngineOriginatedNotificationInfo.setMsgCustomerId(msgCustomerId2);
    HashMap<String, String> msgData = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgData(msgData);
    HashMap<String, String> msgMetadata2 = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgMetadata(msgMetadata2);
    actualRuleEngineOriginatedNotificationInfo.setMsgOriginator(TenantId.SYS_TENANT_ID);
    actualRuleEngineOriginatedNotificationInfo.setMsgType("Msg Type");
    String actualToStringResult = actualRuleEngineOriginatedNotificationInfo.toString();
    CustomerId actualAffectedCustomerId = actualRuleEngineOriginatedNotificationInfo.getAffectedCustomerId();
    CustomerId actualMsgCustomerId = actualRuleEngineOriginatedNotificationInfo.getMsgCustomerId();
    Map<String, String> actualMsgData = actualRuleEngineOriginatedNotificationInfo.getMsgData();
    Map<String, String> actualMsgMetadata = actualRuleEngineOriginatedNotificationInfo.getMsgMetadata();
    EntityId actualMsgOriginator = actualRuleEngineOriginatedNotificationInfo.getMsgOriginator();
    String actualMsgType = actualRuleEngineOriginatedNotificationInfo.getMsgType();
    EntityId actualStateEntityId = actualRuleEngineOriginatedNotificationInfo.getStateEntityId();

    // Assert
    assertEquals("Msg Type", actualMsgType);
    assertEquals(
        "RuleEngineOriginatedNotificationInfo(msgOriginator=13814000-1dd2-11b2-8080-808080808080, msgCustomerId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9, msgType=Msg Type, msgMetadata={}, msgData={})",
        actualToStringResult);
    assertTrue(actualMsgData.isEmpty());
    assertTrue(actualMsgMetadata.isEmpty());
    assertSame(msgData, actualMsgData);
    assertSame(msgMetadata2, actualMsgMetadata);
    assertSame(msgCustomerId2, actualAffectedCustomerId);
    assertSame(msgCustomerId2, actualMsgCustomerId);
    TenantId tenantId = ((TenantId) actualStateEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualMsgOriginator);
    assertSame(tenantId, actualStateEntityId);
  }

  /**
   * Test RuleEngineOriginatedNotificationInfoBuilder {@link RuleEngineOriginatedNotificationInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfoBuilder#build()}
   *   <li>{@link RuleEngineOriginatedNotificationInfoBuilder#msgCustomerId(CustomerId)}
   *   <li>{@link RuleEngineOriginatedNotificationInfoBuilder#msgData(Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfoBuilder#msgMetadata(Map)}
   *   <li>{@link RuleEngineOriginatedNotificationInfoBuilder#msgOriginator(EntityId)}
   *   <li>{@link RuleEngineOriginatedNotificationInfoBuilder#msgType(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineOriginatedNotificationInfoBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleEngineOriginatedNotificationInfoBuilder.<init>()",
      "RuleEngineOriginatedNotificationInfo RuleEngineOriginatedNotificationInfoBuilder.build()",
      "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgCustomerId(CustomerId)",
      "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgData(Map)",
      "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgMetadata(Map)",
      "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgOriginator(EntityId)",
      "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgType(String)",
      "String RuleEngineOriginatedNotificationInfoBuilder.toString()"})
  void testRuleEngineOriginatedNotificationInfoBuilderBuild() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult = RuleEngineOriginatedNotificationInfo.builder();
    CustomerId msgCustomerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult = builderResult.msgCustomerId(msgCustomerId);
    HashMap<String, String> msgData = new HashMap<>();
    RuleEngineOriginatedNotificationInfoBuilder msgDataResult = msgCustomerIdResult.msgData(msgData);
    HashMap<String, String> msgMetadata = new HashMap<>();

    // Act
    RuleEngineOriginatedNotificationInfo actualBuildResult = msgDataResult.msgMetadata(msgMetadata)
        .msgOriginator(TenantId.SYS_TENANT_ID)
        .msgType("Msg Type")
        .build();

    // Assert
    EntityId msgOriginator = actualBuildResult.getMsgOriginator();
    assertTrue(msgOriginator instanceof TenantId);
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(4, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("originatorId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", templateData.get("customerId"));
    assertEquals("Msg Type", templateData.get("msgType"));
    assertEquals("Msg Type", actualBuildResult.getMsgType());
    assertEquals("Tenant", templateData.get("originatorType"));
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getAffectedTenantId());
    assertNull(actualBuildResult.getAffectedUserId());
    Map<String, String> msgData2 = actualBuildResult.getMsgData();
    assertTrue(msgData2.isEmpty());
    Map<String, String> msgMetadata2 = actualBuildResult.getMsgMetadata();
    assertTrue(msgMetadata2.isEmpty());
    assertSame(msgData, msgData2);
    assertSame(msgMetadata, msgMetadata2);
    assertSame(msgCustomerId, actualBuildResult.getAffectedCustomerId());
    assertSame(msgCustomerId, actualBuildResult.getMsgCustomerId());
    assertSame(msgOriginator, actualBuildResult.getStateEntityId());
  }
}
