package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;

class InMemoryTbQueueProducerDiffblueTest {
  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and {@link
   * InMemoryTbQueueProducer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, "Default Topic");
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer2 =
        new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer2);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer2.hashCode());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and {@link
   * InMemoryTbQueueProducer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, null);
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer2 =
        new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer2);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer2.hashCode());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and {@link
   * InMemoryTbQueueProducer#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer.hashCode());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(
        inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertNotEquals(
        inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(
            null, "org.thingsboard.server.queue.memory.InMemoryTbQueueProducer");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, null);
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, "Different type to InMemoryTbQueueProducer");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#InMemoryTbQueueProducer(InMemoryStorage, String)}
   *   <li>{@link InMemoryTbQueueProducer#init()}
   *   <li>{@link InMemoryTbQueueProducer#stop()}
   *   <li>{@link InMemoryTbQueueProducer#toString()}
   *   <li>{@link InMemoryTbQueueProducer#getDefaultTopic()}
   *   <li>{@link InMemoryTbQueueProducer#getStorage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void InMemoryTbQueueProducer.<init>(InMemoryStorage, String)",
    "String InMemoryTbQueueProducer.getDefaultTopic()",
    "InMemoryStorage InMemoryTbQueueProducer.getStorage()",
    "void InMemoryTbQueueProducer.init()",
    "void InMemoryTbQueueProducer.stop()",
    "String InMemoryTbQueueProducer.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    InMemoryTbQueueProducer<TbQueueMsg> actualInMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(storage, "Default Topic");
    actualInMemoryTbQueueProducer.init();
    actualInMemoryTbQueueProducer.stop();
    actualInMemoryTbQueueProducer.toString();
    String actualDefaultTopic = actualInMemoryTbQueueProducer.getDefaultTopic();
    InMemoryStorage actualStorage = actualInMemoryTbQueueProducer.getStorage();

    // Assert
    assertTrue(actualStorage instanceof DefaultInMemoryStorage);
    assertEquals("Default Topic", actualDefaultTopic);
    assertSame(storage, actualStorage);
  }
}
