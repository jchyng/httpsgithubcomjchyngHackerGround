import React, { useEffect, useState } from 'react';
import { SafeAreaView, StyleSheet, Text, AsyncStorage } from 'react-native';
import LogoSvg from '../assets/logo.svg';
import { WithLocalSvg } from 'react-native-svg';
import Font from '../components/Font';

const Loading = ({ navigation }) => {
  const [isCheck, setIsCheck] = useState(false);

  const onCheckUser = async () => {
    const token = await AsyncStorage.getItem('token');

    if (token) setIsCheck(true);
    else setIsCheck(false);
  };

  useEffect(() => {
    onCheckUser();
    setTimeout(() => {
      if (isCheck) navigation.navigate('Nav');
      else navigation.navigate('TopicCheck');
    }, 2000);
  }, [isCheck, navigation]);
  return (
    <SafeAreaView style={styles.container}>
      <WithLocalSvg asset={LogoSvg} />
      <Text style={styles.text}>
        <Font text={'청년 정책 알림이'} />
      </Text>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  text: {
    fontSize: 35,
    marginTop: 23,
  },
});

export default Loading;
