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
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {ComponentDescriptorDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ComponentDescriptorDataValidatorDiffblueTest {
  @Autowired private ComponentDescriptorDataValidator componentDescriptorDataValidator;

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   *
   * <ul>
   *   <li>Given {@code Component name}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"
  })
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenComponentName() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            componentDescriptorDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   *
   * <ul>
   *   <li>Given {@code Component name}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"
  })
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenComponentName2() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setName("Component name\u0000");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            componentDescriptorDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"
  })
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenEmptyString() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setName("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            componentDescriptorDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   *
   * <ul>
   *   <li>Given {@code ENRICHMENT}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"
  })
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenEnrichment() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setType(ComponentType.ENRICHMENT);
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            componentDescriptorDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   *
   * <ul>
   *   <li>Given {@code SYSTEM}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"
  })
  public void testValidateDataImplWithTenantIdComponentDescriptor_givenSystem() {
    // Arrange
    ComponentDescriptor plugin = new ComponentDescriptor();
    plugin.setScope(ComponentScope.SYSTEM);
    plugin.setType(ComponentType.ENRICHMENT);
    plugin.setName("Component name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            componentDescriptorDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, plugin));
  }

  /**
   * Test {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId, ComponentDescriptor)}
   * with {@code TenantId}, {@code ComponentDescriptor}.
   *
   * <ul>
   *   <li>When {@link ComponentDescriptor#ComponentDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link ComponentDescriptorDataValidator#validateDataImpl(TenantId,
   * ComponentDescriptor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComponentDescriptorDataValidator.validateDataImpl(TenantId, ComponentDescriptor)"
  })
  public void testValidateDataImplWithTenantIdComponentDescriptor_whenComponentDescriptor() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            componentDescriptorDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new ComponentDescriptor()));
  }
}
