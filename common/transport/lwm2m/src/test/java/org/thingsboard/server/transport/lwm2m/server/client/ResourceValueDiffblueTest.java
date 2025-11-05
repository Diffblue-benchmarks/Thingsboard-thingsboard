package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Operations;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.LwM2mMultipleResource;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.node.LwM2mResourceInstance;
import org.eclipse.leshan.core.node.LwM2mSingleResource;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.request.WriteRequest.Mode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceValueDiffblueTest {
  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName("Test new ResourceValue(LwM2mResource, ResourceModel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    assertNull(actualResourceValue.getLwM2mResource());
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName("Test new ResourceValue(LwM2mResource, ResourceModel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue2() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, LwM2mResourceInstance.newBooleanInstance(1, true));
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName("Test new ResourceValue(LwM2mResource, ResourceModel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue3() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(
            1, Type.BOOLEAN, LwM2mResourceInstance.newBooleanInstance(1, true));
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <ul>
   *   <li>Then return LwM2mResource is newBooleanResource one and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName(
      "Test new ResourceValue(LwM2mResource, ResourceModel); then return LwM2mResource is newBooleanResource one and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue_thenReturnLwM2mResourceIsNewBooleanResourceOneAndTrue() {
    // Arrange
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newBooleanResource(1, true);
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <ul>
   *   <li>Then return LwM2mResource is newFloatResource one and ten.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName(
      "Test new ResourceValue(LwM2mResource, ResourceModel); then return LwM2mResource is newFloatResource one and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue_thenReturnLwM2mResourceIsNewFloatResourceOneAndTen() {
    // Arrange
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newFloatResource(1, 10.0d);
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <ul>
   *   <li>Then return LwM2mResource is newIntegerResource one and forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName(
      "Test new ResourceValue(LwM2mResource, ResourceModel); then return LwM2mResource is newIntegerResource one and forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue_thenReturnLwM2mResourceIsNewIntegerResourceOneAndFortyTwo() {
    // Arrange
    LwM2mSingleResource lwM2mResource = LwM2mSingleResource.newIntegerResource(1, 42L);
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Assert
    LwM2mResource lwM2mResource2 = actualResourceValue.getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LwM2mResource is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName(
      "Test new ResourceValue(LwM2mResource, ResourceModel); when 'null'; then return LwM2mResource is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue_whenNull_thenReturnLwM2mResourceIsNull() {
    // Arrange
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    // Act
    ResourceValue actualResourceValue = new ResourceValue(null, resourceModel);

    // Assert
    assertNull(actualResourceValue.getLwM2mResource());
    assertSame(resourceModel, actualResourceValue.getResourceModel());
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, Mode.REPLACE);

    // Assert that nothing has changed
    assertNull(resourceValue.getLwM2mResource());
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource2() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mSingleResource lwM2mResource2 = LwM2mSingleResource.newBooleanResource(1, true);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource3() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mSingleResource lwM2mResource2 = LwM2mSingleResource.newFloatResource(1, 10.0d);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource4() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mResourceInstance newBooleanInstanceResult =
        LwM2mResourceInstance.newBooleanInstance(1, true);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, newBooleanInstanceResult);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mMultipleResource);
    Map<Integer, LwM2mResourceInstance> instances = lwM2mResource3.getInstances();
    assertEquals(1, instances.size());
    assertEquals(1, lwM2mResource3.getId());
    assertEquals(Type.NONE, lwM2mResource3.getType());
    assertTrue(lwM2mResource3.isMultiInstances());
    assertSame(newBooleanInstanceResult, instances.get(1));
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource5() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mSingleResource lwM2mResource2 = LwM2mSingleResource.newIntegerResource(1, 42L);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mSingleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource6() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    resourceValue.setLwM2mResource(lwM2mResource2);
    LwM2mResourceInstance newBooleanInstanceResult =
        LwM2mResourceInstance.newBooleanInstance(1, true);
    LwM2mMultipleResource lwM2mResource3 =
        new LwM2mMultipleResource(1, Type.NONE, newBooleanInstanceResult);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource3, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource4 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource4 instanceof LwM2mMultipleResource);
    Map<Integer, LwM2mResourceInstance> instances = lwM2mResource4.getInstances();
    assertEquals(1, instances.size());
    assertSame(newBooleanInstanceResult, instances.get(1));
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource7() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(
            1, Type.BOOLEAN, LwM2mResourceInstance.newBooleanInstance(1, true));

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource2, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource3 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource3 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource2, lwM2mResource3);
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource8() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, LwM2mResourceInstance.newBooleanInstance(1, true));
    resourceValue.setLwM2mResource(lwM2mResource2);
    LwM2mResourceInstance newBooleanInstanceResult =
        LwM2mResourceInstance.newBooleanInstance(1, true);
    LwM2mMultipleResource lwM2mResource3 =
        new LwM2mMultipleResource(1, Type.NONE, newBooleanInstanceResult);

    // Act
    resourceValue.updateLwM2mResource(lwM2mResource3, Mode.REPLACE);

    // Assert
    LwM2mResource lwM2mResource4 = resourceValue.getLwM2mResource();
    assertTrue(lwM2mResource4 instanceof LwM2mMultipleResource);
    Map<Integer, LwM2mResourceInstance> instances = lwM2mResource4.getInstances();
    assertEquals(1, instances.size());
    assertSame(newBooleanInstanceResult, instances.get(1));
  }

  /**
   * Test {@link ResourceValue#updateLwM2mResource(LwM2mResource, Mode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#updateLwM2mResource(LwM2mResource,
   * WriteRequest.Mode)}
   */
  @Test
  @DisplayName("Test updateLwM2mResource(LwM2mResource, Mode); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceValue.updateLwM2mResource(LwM2mResource, WriteRequest.Mode)"})
  void testUpdateLwM2mResource_whenNull() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Act
    resourceValue.updateLwM2mResource(null, Mode.REPLACE);

    // Assert that nothing has changed
    assertNull(resourceValue.getLwM2mResource());
  }

  /**
   * Test {@link ResourceValue#equals(Object)}, and {@link ResourceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceValue#equals(Object)}
   *   <li>{@link ResourceValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceValue resourceValue = new ResourceValue(lwM2mResource, null);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceValue resourceValue2 = new ResourceValue(lwM2mResource2, null);

    // Act and Assert
    assertEquals(resourceValue, resourceValue2);
    assertEquals(resourceValue.hashCode(), resourceValue2.hashCode());
  }

  /**
   * Test {@link ResourceValue#equals(Object)}, and {@link ResourceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceValue#equals(Object)}
   *   <li>{@link ResourceValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Act and Assert
    assertEquals(resourceValue, resourceValue);
    int expectedHashCodeResult = resourceValue.hashCode();
    assertEquals(expectedHashCodeResult, resourceValue.hashCode());
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel2 =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue2 = new ResourceValue(lwM2mResource2, resourceModel2);

    // Act and Assert
    assertNotEquals(resourceValue, resourceValue2);
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceValue resourceValue = new ResourceValue(lwM2mResource, null);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue2 = new ResourceValue(lwM2mResource2, resourceModel);

    // Act and Assert
    assertNotEquals(resourceValue, resourceValue2);
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    resourceValue.setLwM2mResource(lwM2mResource2);
    LwM2mMultipleResource lwM2mResource3 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel2 =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue2 = new ResourceValue(lwM2mResource3, resourceModel2);

    // Act and Assert
    assertNotEquals(resourceValue, resourceValue2);
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel2 =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue2 = new ResourceValue(lwM2mResource2, resourceModel2);
    LwM2mMultipleResource lwM2mResource3 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    resourceValue2.setLwM2mResource(lwM2mResource3);

    // Act and Assert
    assertNotEquals(resourceValue, resourceValue2);
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    resourceValue.setLwM2mResource(lwM2mResource2);
    LwM2mMultipleResource lwM2mResource3 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel2 =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue2 = new ResourceValue(lwM2mResource3, resourceModel2);
    LwM2mMultipleResource lwM2mResource4 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    resourceValue2.setLwM2mResource(lwM2mResource4);

    // Act and Assert
    assertNotEquals(resourceValue, resourceValue2);
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Act and Assert
    assertNotEquals(resourceValue, null);
  }

  /**
   * Test {@link ResourceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);

    // Act and Assert
    assertNotEquals(resourceValue, "Different type to ResourceValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceValue#setLwM2mResource(LwM2mResource)}
   *   <li>{@link ResourceValue#setResourceModel(ResourceModel)}
   *   <li>{@link ResourceValue#toString()}
   *   <li>{@link ResourceValue#getLwM2mResource()}
   *   <li>{@link ResourceValue#getResourceModel()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2mResource ResourceValue.getLwM2mResource()",
    "ResourceModel ResourceValue.getResourceModel()",
    "void ResourceValue.setLwM2mResource(LwM2mResource)",
    "void ResourceValue.setResourceModel(ResourceModel)",
    "String ResourceValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());
    ResourceModel resourceModel =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");

    ResourceValue resourceValue = new ResourceValue(lwM2mResource, resourceModel);
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act
    resourceValue.setLwM2mResource(lwM2mResource2);
    ResourceModel resourceModel2 =
        new ResourceModel(
            1,
            "Name",
            Operations.NONE,
            true,
            true,
            Type.NONE,
            "Range Enumeration",
            "Units",
            "The characteristics of someone or something");
    resourceValue.setResourceModel(resourceModel2);
    String actualToStringResult = resourceValue.toString();
    LwM2mResource actualLwM2mResource = resourceValue.getLwM2mResource();

    // Assert
    assertEquals(
        "ResourceValue(lwM2mResource=LwM2mMultipleResource [id=1, values={}, type=NONE], resourceModel=ResourceDesc"
            + " [id=1, name=Name, operations=NONE, multiple=true, mandatory=true, type=NONE, rangeEnumeration=Range"
            + " Enumeration, units=Units, description=The characteristics of someone or something])",
        actualToStringResult);
    assertSame(resourceModel2, resourceValue.getResourceModel());
    assertSame(lwM2mResource2, actualLwM2mResource);
  }
}
