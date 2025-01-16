package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfig;

class TbDummyLwM2MModelConfigStoreDiffblueTest {
  /**
   * Test {@link TbDummyLwM2MModelConfigStore#getAll()}.
   * <p>
   * Method under test: {@link TbDummyLwM2MModelConfigStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue((new TbDummyLwM2MModelConfigStore()).getAll().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbDummyLwM2MModelConfigStore}
   *   <li>{@link TbDummyLwM2MModelConfigStore#put(LwM2MModelConfig)}
   *   <li>{@link TbDummyLwM2MModelConfigStore#remove(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbDummyLwM2MModelConfigStore actualTbDummyLwM2MModelConfigStore = new TbDummyLwM2MModelConfigStore();
    actualTbDummyLwM2MModelConfigStore.put(new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"));
    actualTbDummyLwM2MModelConfigStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert that nothing has changed
    assertTrue(actualTbDummyLwM2MModelConfigStore.getAll().isEmpty());
  }
}
