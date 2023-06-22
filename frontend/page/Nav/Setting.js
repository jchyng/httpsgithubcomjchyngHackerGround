import {
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';
import React from 'react';
import Font from '../../components/Font';

const Setting = ({ navigation }) => {
  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerText}>
          <Font text={'설정'} />
        </Text>
      </View>
      <View style={styles.settingContainer}>
        <TouchableOpacity
          onPress={() => navigation.navigate('Notification')}
          style={styles.settingButton}>
          <Text style={styles.settingText}>
            <Font text={'알림 설정'} />
          </Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => navigation.navigate('Scrap')}
          style={styles.settingButton}>
          <Text style={styles.settingText}>
            <Font text={'스크랩한 글'} />
          </Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  header: {
    paddingTop: 30,
    paddingBottom: 16,
    paddingHorizontal: 20,
    borderBottomWidth: 1,
    borderBottomColor: '#7F7F7F',
    backgroundColor: '#ffffff',
  },
  headerText: {
    color: '#3F86F8',
    fontSize: 35,
    paddingBottom: 15,
  },
  settingContainer: {
    marginTop: 30,
  },
  settingButton: {
    backgroundColor: '#ffffff',
    padding: 20,
    marginBottom: 5,
  },
  settingText: {
    fontSize: 20,
  },
});
export default Setting;
