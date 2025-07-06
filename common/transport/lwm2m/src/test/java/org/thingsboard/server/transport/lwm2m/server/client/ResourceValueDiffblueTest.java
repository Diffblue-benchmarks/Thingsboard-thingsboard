package org.thingsboard.server.transport.lwm2m.server.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, Type.NONE, instances);

    // Act and Assert
    LwM2mResource lwM2mResource2 =
        new ResourceValue(
                lwM2mResource,
                new ResourceModel(
                    1,
                    "Name",
                    Operations.NONE,
                    true,
                    true,
                    Type.NONE,
                    "Range Enumeration",
                    "Units",
                    "The characteristics of someone or something"))
            .getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    assertEquals(lwM2mResource, lwM2mResource2);
  }

  /**
   * Test {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}.
   *
   * <ul>
   *   <li>Then return LwM2mResource Instances size is two.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName(
      "Test new ResourceValue(LwM2mResource, ResourceModel); then return LwM2mResource Instances size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue_thenReturnLwM2mResourceInstancesSizeIsTwo() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    LwM2mResourceInstance newBooleanInstanceResult =
        LwM2mResourceInstance.newBooleanInstance(2, true);
    instances.add(newBooleanInstanceResult);
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, Type.NONE, instances);

    // Act and Assert
    LwM2mResource lwM2mResource2 =
        new ResourceValue(
                lwM2mResource,
                new ResourceModel(
                    1,
                    "Name",
                    Operations.NONE,
                    true,
                    true,
                    Type.NONE,
                    "Range Enumeration",
                    "Units",
                    "The characteristics of someone or something"))
            .getLwM2mResource();
    assertTrue(lwM2mResource2 instanceof LwM2mMultipleResource);
    Map<Integer, LwM2mResourceInstance> instances2 = lwM2mResource2.getInstances();
    assertEquals(2, instances2.size());
    assertTrue(instances2.containsKey(1));
    assertSame(newBooleanInstanceResult, instances2.get(2));
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then return LwM2mResource is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceValue#ResourceValue(LwM2mResource, ResourceModel)}
   */
  @Test
  @DisplayName(
      "Test new ResourceValue(LwM2mResource, ResourceModel); then return LwM2mResource is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceValue.<init>(LwM2mResource, ResourceModel)"})
  void testNewResourceValue_thenReturnLwM2mResourceIsNull() {
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceValue resourceValue =
        new ResourceValue(new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()), null);
    ResourceValue resourceValue2 =
        new ResourceValue(new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()), null);

    // Act and Assert
    assertEquals(resourceValue, resourceValue2);
    int expectedHashCodeResult = resourceValue.hashCode();
    assertEquals(expectedHashCodeResult, resourceValue2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    ResourceValue resourceValue =
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    ResourceValue resourceValue =
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        resourceValue,
        new ResourceValue(
            lwM2mResource2,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, Type.NONE, instances);

    ResourceValue resourceValue =
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        resourceValue,
        new ResourceValue(
            lwM2mResource2,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceValue resourceValue =
        new ResourceValue(new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>()), null);
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        resourceValue,
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    ResourceValue resourceValue =
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, Type.NONE, instances);

    // Act and Assert
    assertNotEquals(
        resourceValue,
        new ResourceValue(
            lwM2mResource2,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<LwM2mResourceInstance> instances = new ArrayList<>();
    instances.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource = new LwM2mMultipleResource(1, Type.NONE, instances);

    ResourceValue resourceValue =
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something"));

    ArrayList<LwM2mResourceInstance> instances2 = new ArrayList<>();
    instances2.add(LwM2mResourceInstance.newBooleanInstance(1, true));
    LwM2mMultipleResource lwM2mResource2 = new LwM2mMultipleResource(1, Type.NONE, instances2);

    // Act and Assert
    assertNotEquals(
        resourceValue,
        new ResourceValue(
            lwM2mResource2,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")),
        null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ResourceValue.equals(Object)", "int ResourceValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mMultipleResource lwM2mResource =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something")),
        "Different type to ResourceValue");
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
  @Tag("MaintainedByDiffblue")
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

    ResourceValue resourceValue =
        new ResourceValue(
            lwM2mResource,
            new ResourceModel(
                1,
                "Name",
                Operations.NONE,
                true,
                true,
                Type.NONE,
                "Range Enumeration",
                "Units",
                "The characteristics of someone or something"));
    LwM2mMultipleResource lwM2mResource2 =
        new LwM2mMultipleResource(1, Type.NONE, new ArrayList<>());

    // Act
    resourceValue.setLwM2mResource(lwM2mResource2);
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

    resourceValue.setResourceModel(resourceModel);
    String actualToStringResult = resourceValue.toString();
    LwM2mResource actualLwM2mResource = resourceValue.getLwM2mResource();

    // Assert
    assertEquals(
        "ResourceValue(lwM2mResource=LwM2mMultipleResource [id=1, values={}, type=NONE], resourceModel=ResourceDesc"
            + " [id=1, name=Name, operations=NONE, multiple=true, mandatory=true, type=NONE, rangeEnumeration=Range"
            + " Enumeration, units=Units, description=The characteristics of someone or something])",
        actualToStringResult);
    assertSame(resourceModel, resourceValue.getResourceModel());
    assertSame(lwM2mResource2, actualLwM2mResource);
  }
}
