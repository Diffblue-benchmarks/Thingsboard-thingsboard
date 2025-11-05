package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.codec.mqtt.MqttQoS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.mqtt.MqttLastWill.Builder;

@ContextConfiguration(classes = {Builder.class})
@ExtendWith(SpringExtension.class)
class MqttLastWillDiffblueTest {
  @Autowired private Builder builder;

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#setRetain(boolean)}
   *   <li>{@link Builder#getMessage()}
   *   <li>{@link Builder#getTopic()}
   *   <li>{@link Builder#getQos()}
   *   <li>{@link Builder#isRetain()}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "MqttLastWill Builder.build()",
    "String Builder.getMessage()",
    "MqttQoS Builder.getQos()",
    "String Builder.getTopic()",
    "boolean Builder.isRetain()",
    "Builder Builder.setRetain(boolean)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = MqttLastWill.builder();
    Builder actualSetMessageResult = actualBuilderResult.setMessage("Not all who wander are lost");
    Builder actualSetQosResult = actualSetMessageResult.setQos(MqttQoS.AT_MOST_ONCE);
    Builder actualSetRetainResult = actualSetQosResult.setRetain(true);
    Builder actualSetTopicResult = actualSetRetainResult.setTopic("Topic");
    MqttLastWill actualMqttLastWill = actualSetTopicResult.build();

    // Assert
    assertEquals("Not all who wander are lost", actualMqttLastWill.getMessage());
    assertEquals("Not all who wander are lost", actualSetMessageResult.getMessage());
    assertEquals("Not all who wander are lost", actualSetQosResult.getMessage());
    assertEquals("Not all who wander are lost", actualSetRetainResult.getMessage());
    assertEquals("Not all who wander are lost", actualSetTopicResult.getMessage());
    assertEquals("Not all who wander are lost", actualBuilderResult.getMessage());
    assertEquals("Topic", actualMqttLastWill.getTopic());
    assertEquals("Topic", actualSetMessageResult.getTopic());
    assertEquals("Topic", actualSetQosResult.getTopic());
    assertEquals("Topic", actualSetRetainResult.getTopic());
    assertEquals("Topic", actualSetTopicResult.getTopic());
    assertEquals("Topic", actualBuilderResult.getTopic());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualMqttLastWill.getQos());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualSetMessageResult.getQos());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualSetQosResult.getQos());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualSetRetainResult.getQos());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualSetTopicResult.getQos());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualBuilderResult.getQos());
    assertTrue(actualMqttLastWill.isRetain());
    assertTrue(actualSetMessageResult.isRetain());
    assertTrue(actualSetQosResult.isRetain());
    assertTrue(actualSetRetainResult.isRetain());
    assertTrue(actualSetTopicResult.isRetain());
    assertTrue(actualBuilderResult.isRetain());
  }

  /**
   * Test Builder {@link Builder#setMessage(String)}.
   *
   * <ul>
   *   <li>Then builder Message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setMessage(String)}
   */
  @Test
  @DisplayName(
      "Test Builder setMessage(String); then builder Message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setMessage(String)"})
  void testBuilderSetMessage_thenBuilderMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    Builder builderResult = MqttLastWill.builder();

    // Act
    Builder actualSetMessageResult = builderResult.setMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", builderResult.getMessage());
    assertSame(builderResult, actualSetMessageResult);
  }

  /**
   * Test Builder {@link Builder#setQos(MqttQoS)}.
   *
   * <ul>
   *   <li>When {@code AT_MOST_ONCE}.
   *   <li>Then builder Qos is {@code AT_MOST_ONCE}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setQos(MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test Builder setQos(MqttQoS); when 'AT_MOST_ONCE'; then builder Qos is 'AT_MOST_ONCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setQos(MqttQoS)"})
  void testBuilderSetQos_whenAtMostOnce_thenBuilderQosIsAtMostOnce() {
    // Arrange
    Builder builderResult = MqttLastWill.builder();

    // Act
    Builder actualSetQosResult = builderResult.setQos(MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(MqttQoS.AT_MOST_ONCE, builderResult.getQos());
    assertSame(builderResult, actualSetQosResult);
  }

  /**
   * Test Builder {@link Builder#setTopic(String)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then builder Topic is {@code Topic}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setTopic(String)}
   */
  @Test
  @DisplayName("Test Builder setTopic(String); when 'Topic'; then builder Topic is 'Topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setTopic(String)"})
  void testBuilderSetTopic_whenTopic_thenBuilderTopicIsTopic() {
    // Arrange
    Builder builderResult = MqttLastWill.builder();

    // Act
    Builder actualSetTopicResult = builderResult.setTopic("Topic");

    // Assert
    assertEquals("Topic", builderResult.getTopic());
    assertSame(builderResult, actualSetTopicResult);
  }

  /**
   * Test {@link MqttLastWill#MqttLastWill(String, String, boolean, MqttQoS)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then return Message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#MqttLastWill(String, String, boolean, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test new MqttLastWill(String, String, boolean, MqttQoS); when 'Topic'; then return Message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttLastWill.<init>(String, String, boolean, MqttQoS)"})
  void testNewMqttLastWill_whenTopic_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    MqttLastWill actualMqttLastWill =
        new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals("Not all who wander are lost", actualMqttLastWill.getMessage());
    assertEquals("Topic", actualMqttLastWill.getTopic());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualMqttLastWill.getQos());
    assertTrue(actualMqttLastWill.isRetain());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttLastWill#toString()}
   *   <li>{@link MqttLastWill#getMessage()}
   *   <li>{@link MqttLastWill#getQos()}
   *   <li>{@link MqttLastWill#getTopic()}
   *   <li>{@link MqttLastWill#isRetain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MqttLastWill.getMessage()",
    "MqttQoS MqttLastWill.getQos()",
    "String MqttLastWill.getTopic()",
    "boolean MqttLastWill.isRetain()",
    "String MqttLastWill.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();

    // Act
    String actualToStringResult = mqttLastWill.toString();
    String actualMessage = mqttLastWill.getMessage();
    MqttQoS actualQos = mqttLastWill.getQos();
    String actualTopic = mqttLastWill.getTopic();

    // Assert
    assertEquals(
        "MqttLastWill{topic='Topic', message='Not all who wander are lost', retain=true, qos=AT_MOST_ONCE}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Topic", actualTopic);
    assertEquals(MqttQoS.AT_MOST_ONCE, actualQos);
    assertTrue(mqttLastWill.isRetain());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}, and {@link MqttLastWill#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttLastWill#equals(Object)}
   *   <li>{@link MqttLastWill#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();
    MqttLastWill mqttLastWill2 =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();

    // Act and Assert
    assertEquals(mqttLastWill, mqttLastWill2);
    assertEquals(mqttLastWill.hashCode(), mqttLastWill2.hashCode());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}, and {@link MqttLastWill#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttLastWill#equals(Object)}
   *   <li>{@link MqttLastWill#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();

    // Act and Assert
    assertEquals(mqttLastWill, mqttLastWill);
    int expectedHashCodeResult = mqttLastWill.hashCode();
    assertEquals(expectedHashCodeResult, mqttLastWill.hashCode());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Topic")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();

    // Act and Assert
    assertNotEquals(
        mqttLastWill,
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_LEAST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build();

    // Act and Assert
    assertNotEquals(
        mqttLastWill,
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(false)
            .setTopic("Topic")
            .build();

    // Act and Assert
    assertNotEquals(
        mqttLastWill,
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MqttLastWill mqttLastWill =
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        mqttLastWill,
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build());
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build(),
        null);
  }

  /**
   * Test {@link MqttLastWill#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttLastWill.equals(Object)", "int MqttLastWill.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build(),
        "Different type to MqttLastWill");
  }
}
