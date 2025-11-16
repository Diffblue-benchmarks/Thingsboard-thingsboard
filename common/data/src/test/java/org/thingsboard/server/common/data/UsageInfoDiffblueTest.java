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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UsageInfoDiffblueTest {
  /**
   * Test {@link UsageInfo#equals(Object)}, and {@link UsageInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UsageInfo#equals(Object)}
   *   <li>{@link UsageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertEquals(usageInfo, usageInfo2);
    assertEquals(usageInfo.hashCode(), usageInfo2.hashCode());
  }

  /**
   * Test {@link UsageInfo#equals(Object)}, and {@link UsageInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UsageInfo#equals(Object)}
   *   <li>{@link UsageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    // Act and Assert
    assertEquals(usageInfo, usageInfo);
    int expectedHashCodeResult = usageInfo.hashCode();
    assertEquals(expectedHashCodeResult, usageInfo.hashCode());
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(3L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(3L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(3L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(3L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(3L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(3L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(3L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(3L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(3L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(3L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(3L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(3L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(3L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(3L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(3L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(3L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(3L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(3L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(3L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(false);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(null);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(3L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(3L);
    usageInfo.setUsers(1L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(3L);

    UsageInfo usageInfo2 = new UsageInfo();
    usageInfo2.setAlarms(1L);
    usageInfo2.setAssets(1L);
    usageInfo2.setCustomers(1L);
    usageInfo2.setDashboards(1L);
    usageInfo2.setDevices(1L);
    usageInfo2.setEmails(1L);
    usageInfo2.setJsExecutions(1L);
    usageInfo2.setMaxAlarms(1L);
    usageInfo2.setMaxAssets(1L);
    usageInfo2.setMaxCustomers(1L);
    usageInfo2.setMaxDashboards(1L);
    usageInfo2.setMaxDevices(1L);
    usageInfo2.setMaxEmails(1L);
    usageInfo2.setMaxJsExecutions(1L);
    usageInfo2.setMaxSms(1L);
    usageInfo2.setMaxTbelExecutions(1L);
    usageInfo2.setMaxTransportMessages(1L);
    usageInfo2.setMaxUsers(1L);
    usageInfo2.setSms(1L);
    usageInfo2.setSmsEnabled(true);
    usageInfo2.setTbelExecutions(1L);
    usageInfo2.setTransportMessages(1L);
    usageInfo2.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, usageInfo2);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, null);
  }

  /**
   * Test {@link UsageInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UsageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UsageInfo.equals(Object)", "int UsageInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UsageInfo usageInfo = new UsageInfo();
    usageInfo.setAlarms(1L);
    usageInfo.setAssets(1L);
    usageInfo.setCustomers(1L);
    usageInfo.setDashboards(1L);
    usageInfo.setDevices(1L);
    usageInfo.setEmails(1L);
    usageInfo.setJsExecutions(1L);
    usageInfo.setMaxAlarms(1L);
    usageInfo.setMaxAssets(1L);
    usageInfo.setMaxCustomers(1L);
    usageInfo.setMaxDashboards(1L);
    usageInfo.setMaxDevices(1L);
    usageInfo.setMaxEmails(1L);
    usageInfo.setMaxJsExecutions(1L);
    usageInfo.setMaxSms(1L);
    usageInfo.setMaxTbelExecutions(1L);
    usageInfo.setMaxTransportMessages(1L);
    usageInfo.setMaxUsers(1L);
    usageInfo.setSms(1L);
    usageInfo.setSmsEnabled(true);
    usageInfo.setTbelExecutions(1L);
    usageInfo.setTransportMessages(1L);
    usageInfo.setUsers(1L);

    // Act and Assert
    assertNotEquals(usageInfo, "Different type to UsageInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UsageInfo}
   *   <li>{@link UsageInfo#setAlarms(long)}
   *   <li>{@link UsageInfo#setAssets(long)}
   *   <li>{@link UsageInfo#setCustomers(long)}
   *   <li>{@link UsageInfo#setDashboards(long)}
   *   <li>{@link UsageInfo#setDevices(long)}
   *   <li>{@link UsageInfo#setEmails(long)}
   *   <li>{@link UsageInfo#setJsExecutions(long)}
   *   <li>{@link UsageInfo#setMaxAlarms(long)}
   *   <li>{@link UsageInfo#setMaxAssets(long)}
   *   <li>{@link UsageInfo#setMaxCustomers(long)}
   *   <li>{@link UsageInfo#setMaxDashboards(long)}
   *   <li>{@link UsageInfo#setMaxDevices(long)}
   *   <li>{@link UsageInfo#setMaxEmails(long)}
   *   <li>{@link UsageInfo#setMaxJsExecutions(long)}
   *   <li>{@link UsageInfo#setMaxSms(long)}
   *   <li>{@link UsageInfo#setMaxTbelExecutions(long)}
   *   <li>{@link UsageInfo#setMaxTransportMessages(long)}
   *   <li>{@link UsageInfo#setMaxUsers(long)}
   *   <li>{@link UsageInfo#setSms(long)}
   *   <li>{@link UsageInfo#setSmsEnabled(Boolean)}
   *   <li>{@link UsageInfo#setTbelExecutions(long)}
   *   <li>{@link UsageInfo#setTransportMessages(long)}
   *   <li>{@link UsageInfo#setUsers(long)}
   *   <li>{@link UsageInfo#toString()}
   *   <li>{@link UsageInfo#getAlarms()}
   *   <li>{@link UsageInfo#getAssets()}
   *   <li>{@link UsageInfo#getCustomers()}
   *   <li>{@link UsageInfo#getDashboards()}
   *   <li>{@link UsageInfo#getDevices()}
   *   <li>{@link UsageInfo#getEmails()}
   *   <li>{@link UsageInfo#getJsExecutions()}
   *   <li>{@link UsageInfo#getMaxAlarms()}
   *   <li>{@link UsageInfo#getMaxAssets()}
   *   <li>{@link UsageInfo#getMaxCustomers()}
   *   <li>{@link UsageInfo#getMaxDashboards()}
   *   <li>{@link UsageInfo#getMaxDevices()}
   *   <li>{@link UsageInfo#getMaxEmails()}
   *   <li>{@link UsageInfo#getMaxJsExecutions()}
   *   <li>{@link UsageInfo#getMaxSms()}
   *   <li>{@link UsageInfo#getMaxTbelExecutions()}
   *   <li>{@link UsageInfo#getMaxTransportMessages()}
   *   <li>{@link UsageInfo#getMaxUsers()}
   *   <li>{@link UsageInfo#getSms()}
   *   <li>{@link UsageInfo#getSmsEnabled()}
   *   <li>{@link UsageInfo#getTbelExecutions()}
   *   <li>{@link UsageInfo#getTransportMessages()}
   *   <li>{@link UsageInfo#getUsers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UsageInfo.<init>()",
    "long UsageInfo.getAlarms()",
    "long UsageInfo.getAssets()",
    "long UsageInfo.getCustomers()",
    "long UsageInfo.getDashboards()",
    "long UsageInfo.getDevices()",
    "long UsageInfo.getEmails()",
    "long UsageInfo.getJsExecutions()",
    "long UsageInfo.getMaxAlarms()",
    "long UsageInfo.getMaxAssets()",
    "long UsageInfo.getMaxCustomers()",
    "long UsageInfo.getMaxDashboards()",
    "long UsageInfo.getMaxDevices()",
    "long UsageInfo.getMaxEmails()",
    "long UsageInfo.getMaxJsExecutions()",
    "long UsageInfo.getMaxSms()",
    "long UsageInfo.getMaxTbelExecutions()",
    "long UsageInfo.getMaxTransportMessages()",
    "long UsageInfo.getMaxUsers()",
    "long UsageInfo.getSms()",
    "Boolean UsageInfo.getSmsEnabled()",
    "long UsageInfo.getTbelExecutions()",
    "long UsageInfo.getTransportMessages()",
    "long UsageInfo.getUsers()",
    "void UsageInfo.setAlarms(long)",
    "void UsageInfo.setAssets(long)",
    "void UsageInfo.setCustomers(long)",
    "void UsageInfo.setDashboards(long)",
    "void UsageInfo.setDevices(long)",
    "void UsageInfo.setEmails(long)",
    "void UsageInfo.setJsExecutions(long)",
    "void UsageInfo.setMaxAlarms(long)",
    "void UsageInfo.setMaxAssets(long)",
    "void UsageInfo.setMaxCustomers(long)",
    "void UsageInfo.setMaxDashboards(long)",
    "void UsageInfo.setMaxDevices(long)",
    "void UsageInfo.setMaxEmails(long)",
    "void UsageInfo.setMaxJsExecutions(long)",
    "void UsageInfo.setMaxSms(long)",
    "void UsageInfo.setMaxTbelExecutions(long)",
    "void UsageInfo.setMaxTransportMessages(long)",
    "void UsageInfo.setMaxUsers(long)",
    "void UsageInfo.setSms(long)",
    "void UsageInfo.setSmsEnabled(Boolean)",
    "void UsageInfo.setTbelExecutions(long)",
    "void UsageInfo.setTransportMessages(long)",
    "void UsageInfo.setUsers(long)",
    "String UsageInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UsageInfo actualUsageInfo = new UsageInfo();
    actualUsageInfo.setAlarms(1L);
    actualUsageInfo.setAssets(1L);
    actualUsageInfo.setCustomers(1L);
    actualUsageInfo.setDashboards(1L);
    actualUsageInfo.setDevices(1L);
    actualUsageInfo.setEmails(1L);
    actualUsageInfo.setJsExecutions(1L);
    actualUsageInfo.setMaxAlarms(1L);
    actualUsageInfo.setMaxAssets(1L);
    actualUsageInfo.setMaxCustomers(1L);
    actualUsageInfo.setMaxDashboards(1L);
    actualUsageInfo.setMaxDevices(1L);
    actualUsageInfo.setMaxEmails(1L);
    actualUsageInfo.setMaxJsExecutions(1L);
    actualUsageInfo.setMaxSms(1L);
    actualUsageInfo.setMaxTbelExecutions(1L);
    actualUsageInfo.setMaxTransportMessages(1L);
    actualUsageInfo.setMaxUsers(1L);
    actualUsageInfo.setSms(1L);
    actualUsageInfo.setSmsEnabled(true);
    actualUsageInfo.setTbelExecutions(1L);
    actualUsageInfo.setTransportMessages(1L);
    actualUsageInfo.setUsers(1L);
    String actualToStringResult = actualUsageInfo.toString();
    long actualAlarms = actualUsageInfo.getAlarms();
    long actualAssets = actualUsageInfo.getAssets();
    long actualCustomers = actualUsageInfo.getCustomers();
    long actualDashboards = actualUsageInfo.getDashboards();
    long actualDevices = actualUsageInfo.getDevices();
    long actualEmails = actualUsageInfo.getEmails();
    long actualJsExecutions = actualUsageInfo.getJsExecutions();
    long actualMaxAlarms = actualUsageInfo.getMaxAlarms();
    long actualMaxAssets = actualUsageInfo.getMaxAssets();
    long actualMaxCustomers = actualUsageInfo.getMaxCustomers();
    long actualMaxDashboards = actualUsageInfo.getMaxDashboards();
    long actualMaxDevices = actualUsageInfo.getMaxDevices();
    long actualMaxEmails = actualUsageInfo.getMaxEmails();
    long actualMaxJsExecutions = actualUsageInfo.getMaxJsExecutions();
    long actualMaxSms = actualUsageInfo.getMaxSms();
    long actualMaxTbelExecutions = actualUsageInfo.getMaxTbelExecutions();
    long actualMaxTransportMessages = actualUsageInfo.getMaxTransportMessages();
    long actualMaxUsers = actualUsageInfo.getMaxUsers();
    long actualSms = actualUsageInfo.getSms();
    Boolean actualSmsEnabled = actualUsageInfo.getSmsEnabled();
    long actualTbelExecutions = actualUsageInfo.getTbelExecutions();
    long actualTransportMessages = actualUsageInfo.getTransportMessages();

    // Assert
    assertEquals(
        "UsageInfo(devices=1, maxDevices=1, assets=1, maxAssets=1, customers=1, maxCustomers=1, users=1,"
            + " maxUsers=1, dashboards=1, maxDashboards=1, transportMessages=1, maxTransportMessages=1, jsExecutions=1,"
            + " tbelExecutions=1, maxJsExecutions=1, maxTbelExecutions=1, emails=1, maxEmails=1, sms=1, maxSms=1,"
            + " smsEnabled=true, alarms=1, maxAlarms=1)",
        actualToStringResult);
    assertEquals(1L, actualAlarms);
    assertEquals(1L, actualAssets);
    assertEquals(1L, actualCustomers);
    assertEquals(1L, actualDashboards);
    assertEquals(1L, actualDevices);
    assertEquals(1L, actualEmails);
    assertEquals(1L, actualJsExecutions);
    assertEquals(1L, actualMaxAlarms);
    assertEquals(1L, actualMaxAssets);
    assertEquals(1L, actualMaxCustomers);
    assertEquals(1L, actualMaxDashboards);
    assertEquals(1L, actualMaxDevices);
    assertEquals(1L, actualMaxEmails);
    assertEquals(1L, actualMaxJsExecutions);
    assertEquals(1L, actualMaxSms);
    assertEquals(1L, actualMaxTbelExecutions);
    assertEquals(1L, actualMaxTransportMessages);
    assertEquals(1L, actualMaxUsers);
    assertEquals(1L, actualSms);
    assertEquals(1L, actualTbelExecutions);
    assertEquals(1L, actualTransportMessages);
    assertEquals(1L, actualUsageInfo.getUsers());
    assertTrue(actualSmsEnabled);
  }
}
