package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.xml.validation.SchemaFactory;
import org.apache.xerces.jaxp.validation.XMLSchemaFactory;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.LwM2m.LwM2mVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDefaultDDFFileValidatorDiffblueTest {
  /**
   * Test {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}.
   *
   * <ul>
   *   <li>When {@link LwM2mVersion}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#TbDefaultDDFFileValidator(LwM2mVersion)}
   */
  @Test
  @DisplayName(
      "Test new TbDefaultDDFFileValidator(LwM2mVersion); when LwM2mVersion; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDefaultDDFFileValidator.<init>(LwM2mVersion)"})
  void testNewTbDefaultDDFFileValidator_whenLwM2mVersion_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new TbDefaultDDFFileValidator(mock(LwM2mVersion.class)));
  }

  /**
   * Test {@link TbDefaultDDFFileValidator#createSchemaFactory()}.
   *
   * <p>Method under test: {@link TbDefaultDDFFileValidator#createSchemaFactory()}
   */
  @Test
  @DisplayName("Test createSchemaFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SchemaFactory TbDefaultDDFFileValidator.createSchemaFactory()"})
  void testCreateSchemaFactory() {
    // Arrange and Act
    SchemaFactory actualCreateSchemaFactoryResult =
        new TbDefaultDDFFileValidator().createSchemaFactory();

    // Assert
    assertTrue(actualCreateSchemaFactoryResult instanceof XMLSchemaFactory);
    assertNull(actualCreateSchemaFactoryResult.getResourceResolver());
    assertNull(actualCreateSchemaFactoryResult.getErrorHandler());
  }
}
