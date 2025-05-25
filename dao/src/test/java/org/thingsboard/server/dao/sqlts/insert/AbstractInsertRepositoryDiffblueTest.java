package org.thingsboard.server.dao.sqlts.insert;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.sql.attributes.AttributeKvInsertRepository;

public class AbstractInsertRepositoryDiffblueTest {
  /**
   * Test {@link AbstractInsertRepository#replaceNullChars(String)}.
   * <p>
   * Method under test: {@link AbstractInsertRepository#replaceNullChars(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractInsertRepository.replaceNullChars(String)"})
  public void testReplaceNullChars() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals("42", (new AttributeKvInsertRepository()).replaceNullChars("42"));
  }
}
