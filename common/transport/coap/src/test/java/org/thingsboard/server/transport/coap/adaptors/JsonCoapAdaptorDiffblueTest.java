package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JsonCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonCoapAdaptorDiffblueTest {
  @Autowired private JsonCoapAdaptor jsonCoapAdaptor;

  /**
   * Test {@link JsonCoapAdaptor#getContentFormat()}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#getContentFormat()}
   */
  @Test
  @DisplayName("Test getContentFormat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsonCoapAdaptor.getContentFormat()"})
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(50, jsonCoapAdaptor.getContentFormat());
  }
}
