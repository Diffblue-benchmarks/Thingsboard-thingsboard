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

@ContextConfiguration(classes = {ProtoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class ProtoCoapAdaptorDiffblueTest {
  @Autowired
  private ProtoCoapAdaptor protoCoapAdaptor;

  /**
   * Test {@link ProtoCoapAdaptor#getContentFormat()}.
   * <p>
   * Method under test: {@link ProtoCoapAdaptor#getContentFormat()}
   */
  @Test
  @DisplayName("Test getContentFormat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoCoapAdaptor.getContentFormat()"})
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(42, protoCoapAdaptor.getContentFormat());
  }
}
