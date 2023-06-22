import {
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
  Image,
  Switch,
} from 'react-native';
import React, { useState } from 'react';
import Font from './components/Font';
import { WithLocalSvg } from 'react-native-svg';
import Back from './assets/back.svg';

const onBack = ({ navigation }) => {
  navigation.nagigate('Seting');
};

const Notification = () => {
  const [topicCheck, setTopicCheck] = useState([
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
  ]);

  const onCheck = index => {
    const newCheck = [...topicCheck];

    newCheck[index] = !newCheck[index];
    setTopicCheck(newCheck);
  };

  const [isAlert, setIsAlert] = useState(false);
  const toggleAlertSwitch = () => setIsAlert(previousState => !previousState);

  const [isNightAlert, setIsNightAlert] = useState(false);
  const toggleNightSwitch = () => setIsNightAlert(previousState => !previousState);

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.header}>
        <TouchableOpacity onPress={onBack}>
          <WithLocalSvg asset={Back} style={styles.back} />
        </TouchableOpacity>
        <Text style={styles.mainTitle}>
          <Font text={'알림 설정'} />
        </Text>
      </View>
      <View>
        <View style={styles.alert}>
          <View style={styles.doAlert}>
            <Text>
              <Font text='알람 여부' />
            </Text>
            <Switch
              trackColor={{ false: '#767577', true: '#81b0ff' }}
              thumbColor={isAlert ? '#f5dd4b' : '#f4f3f4'}
              ios_backgroundColor="#3e3e3e"
              onValueChange={toggleAlertSwitch}
              value={isAlert}
            />
          </View>
          <View style={styles.nightAlert}>
            <Font text='방해 금지 모드' />
            <Font text='23시 ~ 8시' />
            <Switch
              trackColor={{ false: '#767577', true: '#81b0ff' }}
              thumbColor={isAlert ? '#f5dd4b' : '#f4f3f4'}
              ios_backgroundColor="#3e3e3e"
              onValueChange={toggleAlertSwitch}
              value={isAlert}
            />
          </View>
        </View>
        <View>
          <View style={styles.topicItem}>
            <Text style={styles.topicTitle}>
              <Font text={'Dash : 대구 기술창업의 모든 것'} />
            </Text>
            <View style={styles.topicButtonList}>
              <TouchableOpacity
                onPress={() => onCheck(0)}
                style={[styles.topicButton, topicCheck[0] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[0] ? styles.checkText : styles.topicText]}>
                  <Font text={'지원 사업 공고'} />
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                onPress={() => onCheck(1)}
                style={[styles.topicButton, topicCheck[1] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[1] ? styles.checkText : styles.topicText]}>
                  <Font text={'입주 공간'} />
                </Text>
              </TouchableOpacity>
            </View>
          </View>
          <View style={styles.topicItem}>
            <Text style={styles.topicTitle}>
              <Font text={'청년 정책 : 대구 청년들을 위한 정책'} />
            </Text>
            <View style={styles.topicButtonList}>
              <TouchableOpacity
                onPress={() => onCheck(2)}
                style={[styles.topicButton, topicCheck[2] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[2] ? styles.checkText : styles.topicText]}>
                  <Font text={'일자리'} />
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                onPress={() => onCheck(3)}
                style={[styles.topicButton, topicCheck[3] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[3] ? styles.checkText : styles.topicText]}>
                  <Font text={'추가'} />
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                onPress={() => onCheck(4)}
                style={[styles.topicButton, topicCheck[4] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[4] ? styles.checkText : styles.topicText]}>
                  <Font text={'교육'} />
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                onPress={() => onCheck(5)}
                style={[styles.topicButton, topicCheck[5] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[5] ? styles.checkText : styles.topicText]}>
                  <Font text={'복지 문화'} />
                </Text>
              </TouchableOpacity>
            </View>
          </View>
          <View style={styles.topicItem}>
            <Text style={styles.topicTitle}>
              <Font text={'일자리 포털 : 채용 정보'} />
            </Text>
            <View style={styles.topicButtonList}>
              <TouchableOpacity
                onPress={() => onCheck(6)}
                style={[styles.topicButton, topicCheck[6] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[6] ? styles.checkText : styles.topicText]}>
                  <Font text={'공무원'} />
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                onPress={() => onCheck(7)}
                style={[styles.topicButton, topicCheck[7] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[7] ? styles.checkText : styles.topicText]}>
                  <Font text={'공기업'} />
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                onPress={() => onCheck(8)}
                style={[styles.topicButton, topicCheck[8] ? styles.checkButton : styles.disabledButton]}>
                <Text style={[styles.topicText, topicCheck[8] ? styles.checkText : styles.topicText]}>
                  <Font text={'사기업'} />
                </Text>
              </TouchableOpacity>
            </View>
          </View>
        </View>
      </View>
      <View>
        <Text style={styles.ms}>
          <Font text={'@Microsoft 2023 HakersGround "Whrer are you going"'} />
        </Text>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#F4F4F4'
  },
  header: {
    backgroundColor: '#fff',
    flexDirection: 'row',
    alignContent: 'center',
    padding: 20,
    paddingTop: 30,
    borderBottomWidth: 1,
    borderColor: '#7F7F7F',
    backgroundColor: '#fff',
  },
  back: {
    marginTop: 5,
  },
  mainTitle: {
    fontSize: 24,
    color: '#3F86F8',
    marginLeft: 10,
    textAlignVertical: 'center',
  },
  alert: {
    marginVertical: '5%',
  },
  doAlert: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    width: '100%',
    backgroundColor: '#fff',
    marginBottom: 10,
    padding: '5%',
  },
  nightAlert: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    backgroundColor: '#fff',
    marginBottom: 10,
    padding: '5%',
  },
  topicItem: {
    backgroundColor: '#fff',
    width: '100%',
    marginBottom: '5%',
    padding: 20,
  },
  topicTitle: {
    marginBottom: 10,
  },
  topicButton: {
    height: 30,
    padding: 5,
    borderWidth: 1,
    borderRadius: 5,
    marginRight: 20,
  },
  topicButtonList: {
    flexDirection: 'row',
  },
  checkButton: {
    backgroundColor: '#3F86F8',
    borderColor: '#3F86F8',
  },
  checkText: {
    color: '#fff',
  },
  disabledButton: {
    backgroundColor: '#fff',
    borderColor: '#B6B6B6',
  },
  ms: {
    marginTop: '25%',
    marginLeft: '10%',
  }
});

export default Notification;
