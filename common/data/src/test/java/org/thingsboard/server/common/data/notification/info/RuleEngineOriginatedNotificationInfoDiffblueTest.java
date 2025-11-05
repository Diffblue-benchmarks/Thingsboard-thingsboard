package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
   *
   * <ul>
   *   <li>Then return {@code customerId} is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName(
      "Test getTemplateData(); then return 'customerId' is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RuleEngineOriginatedNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnCustomerIdIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());

    // Act
    Map<String, String> actualTemplateData =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(4, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("originatorId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateData.get("customerId"));
    assertEquals("Msg Type", actualTemplateData.get("msgType"));
    assertEquals("Tenant", actualTemplateData.get("originatorType"));
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code customerId} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'customerId' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RuleEngineOriginatedNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnCustomerIdIsEmptyString() {
    // Arrange
    HashMap<String, String> msgMetadata = new HashMap<>();
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        new RuleEngineOriginatedNotificationInfo(
            TenantId.SYS_TENANT_ID, null, "Msg Type", msgMetadata, new HashMap<>());

    // Act
    Map<String, String> actualTemplateData = ruleEngineOriginatedNotificationInfo.getTemplateData();

    // Assert
    assertEquals(4, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("customerId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("originatorId"));
    assertEquals("Msg Type", actualTemplateData.get("msgType"));
    assertEquals("Tenant", actualTemplateData.get("originatorType"));
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link
   * RuleEngineOriginatedNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo2 =
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    // Act and Assert
    assertEquals(ruleEngineOriginatedNotificationInfo, ruleEngineOriginatedNotificationInfo2);
    assertEquals(
        ruleEngineOriginatedNotificationInfo.hashCode(),
        ruleEngineOriginatedNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link
   * RuleEngineOriginatedNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        RuleEngineOriginatedNotificationInfo.builder().msgCustomerId(null);

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        RuleEngineOriginatedNotificationInfo.builder().msgCustomerId(null);

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo2 =
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    // Act and Assert
    assertEquals(ruleEngineOriginatedNotificationInfo, ruleEngineOriginatedNotificationInfo2);
    assertEquals(
        ruleEngineOriginatedNotificationInfo.hashCode(),
        ruleEngineOriginatedNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link
   * RuleEngineOriginatedNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult.msgMetadata(new HashMap<>()).msgOriginator(null).msgType("Msg Type").build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo2 =
        msgDataResult2.msgMetadata(new HashMap<>()).msgOriginator(null).msgType("Msg Type").build();

    // Act and Assert
    assertEquals(ruleEngineOriginatedNotificationInfo, ruleEngineOriginatedNotificationInfo2);
    assertEquals(
        ruleEngineOriginatedNotificationInfo.hashCode(),
        ruleEngineOriginatedNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}, and {@link
   * RuleEngineOriginatedNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   *   <li>{@link RuleEngineOriginatedNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    // Act and Assert
    assertEquals(ruleEngineOriginatedNotificationInfo, ruleEngineOriginatedNotificationInfo);
    int expectedHashCodeResult = ruleEngineOriginatedNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleEngineOriginatedNotificationInfo.hashCode());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(new CustomerId(EntityId.NULL_UUID));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        RuleEngineOriginatedNotificationInfo.builder().msgCustomerId(null);

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<String, String> msgData = new HashMap<>();
    msgData.put("Msg Type", "42");

    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        builderResult
            .msgCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .msgData(msgData);
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<String, String> msgMetadata = new HashMap<>();
    msgMetadata.put("Msg Type", "42");

    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgCustomerIdResult
            .msgData(new HashMap<>())
            .msgMetadata(msgMetadata)
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult.msgMetadata(new HashMap<>()).msgOriginator(null).msgType("Msg Type").build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());

    RuleEngineOriginatedNotificationInfoBuilder msgMetadataResult =
        msgDataResult.msgMetadata(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgMetadataResult
            .msgOriginator(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .msgType("Msg Type")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType(null)
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());
    RuleEngineOriginatedNotificationInfo ruleEngineOriginatedNotificationInfo =
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("42")
            .build();

    RuleEngineOriginatedNotificationInfoBuilder builderResult2 =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult2 =
        builderResult2.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult2 =
        msgCustomerIdResult2.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineOriginatedNotificationInfo,
        msgDataResult2
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build());
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build(),
        null);
  }

  /**
   * Test {@link RuleEngineOriginatedNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineOriginatedNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineOriginatedNotificationInfo.equals(Object)",
    "int RuleEngineOriginatedNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineOriginatedNotificationInfoBuilder builderResult =
        RuleEngineOriginatedNotificationInfo.builder();

    RuleEngineOriginatedNotificationInfoBuilder msgCustomerIdResult =
        builderResult.msgCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleEngineOriginatedNotificationInfoBuilder msgDataResult =
        msgCustomerIdResult.msgData(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        msgDataResult
            .msgMetadata(new HashMap<>())
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build(),
        "Different type to RuleEngineOriginatedNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineOriginatedNotificationInfo.<init>()",
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
    "String RuleEngineOriginatedNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleEngineOriginatedNotificationInfo actualRuleEngineOriginatedNotificationInfo =
        new RuleEngineOriginatedNotificationInfo();
    CustomerId msgCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleEngineOriginatedNotificationInfo.setMsgCustomerId(msgCustomerId);
    HashMap<String, String> msgData = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgData(msgData);
    HashMap<String, String> msgMetadata = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgMetadata(msgMetadata);
    actualRuleEngineOriginatedNotificationInfo.setMsgOriginator(TenantId.SYS_TENANT_ID);
    actualRuleEngineOriginatedNotificationInfo.setMsgType("Msg Type");
    String actualToStringResult = actualRuleEngineOriginatedNotificationInfo.toString();
    CustomerId actualAffectedCustomerId =
        actualRuleEngineOriginatedNotificationInfo.getAffectedCustomerId();
    CustomerId actualMsgCustomerId = actualRuleEngineOriginatedNotificationInfo.getMsgCustomerId();
    Map<String, String> actualMsgData = actualRuleEngineOriginatedNotificationInfo.getMsgData();
    Map<String, String> actualMsgMetadata =
        actualRuleEngineOriginatedNotificationInfo.getMsgMetadata();
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
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RuleEngineOriginatedNotificationInfo#RuleEngineOriginatedNotificationInfo(EntityId,
   *       CustomerId, String, Map, Map)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineOriginatedNotificationInfo.<init>()",
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
    "String RuleEngineOriginatedNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange
    CustomerId msgCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashMap<String, String> msgMetadata = new HashMap<>();

    // Act
    RuleEngineOriginatedNotificationInfo actualRuleEngineOriginatedNotificationInfo =
        new RuleEngineOriginatedNotificationInfo(
            TenantId.SYS_TENANT_ID, msgCustomerId, "Msg Type", msgMetadata, new HashMap<>());
    CustomerId msgCustomerId2 =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleEngineOriginatedNotificationInfo.setMsgCustomerId(msgCustomerId2);
    HashMap<String, String> msgData = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgData(msgData);
    HashMap<String, String> msgMetadata2 = new HashMap<>();
    actualRuleEngineOriginatedNotificationInfo.setMsgMetadata(msgMetadata2);
    actualRuleEngineOriginatedNotificationInfo.setMsgOriginator(TenantId.SYS_TENANT_ID);
    actualRuleEngineOriginatedNotificationInfo.setMsgType("Msg Type");
    String actualToStringResult = actualRuleEngineOriginatedNotificationInfo.toString();
    CustomerId actualAffectedCustomerId =
        actualRuleEngineOriginatedNotificationInfo.getAffectedCustomerId();
    CustomerId actualMsgCustomerId = actualRuleEngineOriginatedNotificationInfo.getMsgCustomerId();
    Map<String, String> actualMsgData = actualRuleEngineOriginatedNotificationInfo.getMsgData();
    Map<String, String> actualMsgMetadata =
        actualRuleEngineOriginatedNotificationInfo.getMsgMetadata();
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
   * Test RuleEngineOriginatedNotificationInfoBuilder {@link
   * RuleEngineOriginatedNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineOriginatedNotificationInfoBuilder.<init>()",
    "RuleEngineOriginatedNotificationInfo RuleEngineOriginatedNotificationInfoBuilder.build()",
    "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgCustomerId(CustomerId)",
    "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgData(Map)",
    "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgMetadata(Map)",
    "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgOriginator(EntityId)",
    "RuleEngineOriginatedNotificationInfoBuilder RuleEngineOriginatedNotificationInfoBuilder.msgType(String)",
    "String RuleEngineOriginatedNotificationInfoBuilder.toString()"
  })
  void testRuleEngineOriginatedNotificationInfoBuilderBuild() {
    // Arrange and Act
    RuleEngineOriginatedNotificationInfoBuilder actualBuilderResult =
        RuleEngineOriginatedNotificationInfo.builder();
    CustomerId msgCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleEngineOriginatedNotificationInfoBuilder actualMsgCustomerIdResult =
        actualBuilderResult.msgCustomerId(msgCustomerId);
    HashMap<String, String> msgData = new HashMap<>();
    RuleEngineOriginatedNotificationInfoBuilder actualMsgDataResult =
        actualMsgCustomerIdResult.msgData(msgData);
    HashMap<String, String> msgMetadata = new HashMap<>();
    RuleEngineOriginatedNotificationInfo actualRuleEngineOriginatedNotificationInfo =
        actualMsgDataResult
            .msgMetadata(msgMetadata)
            .msgOriginator(TenantId.SYS_TENANT_ID)
            .msgType("Msg Type")
            .build();

    // Assert
    Map<String, String> templateData = actualRuleEngineOriginatedNotificationInfo.getTemplateData();
    assertEquals(4, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("originatorId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", templateData.get("customerId"));
    assertEquals("Msg Type", templateData.get("msgType"));
    assertEquals("Msg Type", actualRuleEngineOriginatedNotificationInfo.getMsgType());
    assertEquals("Tenant", templateData.get("originatorType"));
    assertNull(actualRuleEngineOriginatedNotificationInfo.getDashboardId());
    assertNull(actualRuleEngineOriginatedNotificationInfo.getAffectedTenantId());
    assertNull(actualRuleEngineOriginatedNotificationInfo.getAffectedUserId());
    Map<String, String> msgData2 = actualRuleEngineOriginatedNotificationInfo.getMsgData();
    assertTrue(msgData2.isEmpty());
    Map<String, String> msgMetadata2 = actualRuleEngineOriginatedNotificationInfo.getMsgMetadata();
    assertTrue(msgMetadata2.isEmpty());
    assertSame(msgData, msgData2);
    assertSame(msgMetadata, msgMetadata2);
    assertSame(msgCustomerId, actualRuleEngineOriginatedNotificationInfo.getAffectedCustomerId());
    assertSame(msgCustomerId, actualRuleEngineOriginatedNotificationInfo.getMsgCustomerId());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualRuleEngineOriginatedNotificationInfo.getMsgOriginator());
    assertSame(tenantId, actualRuleEngineOriginatedNotificationInfo.getStateEntityId());
  }
}
