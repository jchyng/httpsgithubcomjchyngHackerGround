import React from 'react';
import { StyleSheet, Text } from 'react-native';

const Font = ({ text }) => {
  return (
    <>
      <Text style={styles.fontStyle}>{text}</Text>
    </>
  );
};

const styles = StyleSheet.create({
  fontStyle: {
    fontFamily: 'Pretendard-Bold',
  },
});

export default Font;
