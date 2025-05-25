package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmCommentDiffblueTest {
  /**
   * Test {@link AlarmComment#getId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.AlarmCommentId AlarmComment.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AlarmComment()).getId());
  }

  /**
   * Test {@link AlarmComment#getCreatedTime()}.
   * <p>
   * Method under test: {@link AlarmComment#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AlarmComment.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AlarmComment()).getCreatedTime());
  }

  /**
   * Test {@link AlarmComment#AlarmComment(AlarmComment)}.
   * <p>
   * Method under test: {@link AlarmComment#AlarmComment(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmComment(AlarmComment)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmComment.<init>(AlarmComment)"})
  void testNewAlarmComment() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertEquals(alarmComment, new AlarmComment(alarmComment));
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Given {@link AlarmComment#AlarmComment()} Comment is Instance.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); given AlarmComment() Comment is Instance; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_givenAlarmCommentCommentIsInstance_thenReturnEmptyString() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(MissingNode.getInstance());

    // Act and Assert
    assertEquals("", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code [2,null]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[2,null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_thenReturn2Null() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.addPOJO(2);
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[2,null]", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals("[]", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code [null]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_thenReturnNull() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[null]", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   * <ul>
   *   <li>Then return {@code [null,null]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[null,null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_thenReturnNullNull() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.add(MissingNode.getInstance());
    comment.add(MissingNode.getInstance());

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[null,null]", alarmComment.getName());
  }
}
