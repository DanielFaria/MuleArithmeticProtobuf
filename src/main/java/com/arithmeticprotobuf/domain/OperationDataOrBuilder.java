// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package com.arithmeticprotobuf.domain;

public interface OperationDataOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // required double operatorOne = 1;
  /**
   * <code>required double operatorOne = 1;</code>
   */
  boolean hasOperatorOne();
  /**
   * <code>required double operatorOne = 1;</code>
   */
  double getOperatorOne();

  // required double operatorTwo = 2;
  /**
   * <code>required double operatorTwo = 2;</code>
   */
  boolean hasOperatorTwo();
  /**
   * <code>required double operatorTwo = 2;</code>
   */
  double getOperatorTwo();

  // required .tutorial.OperationData.Operation operation = 3;
  /**
   * <code>required .tutorial.OperationData.Operation operation = 3;</code>
   */
  boolean hasOperation();
  /**
   * <code>required .tutorial.OperationData.Operation operation = 3;</code>
   */
  com.arithmeticprotobuf.domain.OperationData.Operation getOperation();
}