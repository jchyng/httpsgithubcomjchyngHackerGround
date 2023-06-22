import {
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';
import React, { useState } from 'react';
import Font from '../../components/Font';
import { data } from './Dash';
import { WithLocalSvg } from 'react-native-svg';
import Bookmark from '../../assets/bookmark.svg';

const YouthPolicy = ({ navigation }) => {
  const [isActive, setIsActive] = useState(0);
  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerText}>
          <Font text={'청년 정책'} />
        </Text>
        <View style={styles.category}>
          <TouchableOpacity
            onPress={() => setIsActive(0)}
            style={styles.categoryButton}>
            <Text
              style={[
                styles.categoryText,
                isActive === 0 ? styles.activeText : null,
              ]}>
              <Font text={'일자리'} />
            </Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => setIsActive(1)}
            style={styles.categoryButton}>
            <Text
              style={[
                styles.categoryText,
                isActive === 1 ? styles.activeText : null,
              ]}>
              <Font text={'주거'} />
            </Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => setIsActive(2)}
            style={styles.categoryButton}>
            <Text
              style={[
                styles.categoryText,
                isActive === 2 ? styles.activeText : null,
              ]}>
              <Font text={'교육'} />
            </Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => setIsActive(3)}
            style={styles.categoryButton}>
            <Text
              style={[
                styles.categoryText,
                isActive === 3 ? styles.activeText : null,
              ]}>
              <Font text={'복지문화'} />
            </Text>
          </TouchableOpacity>
        </View>
      </View>
      <ScrollView style={styles.list}>
        {data.map((item, idx) => (
          <TouchableOpacity style={styles.item} key={idx}>
            <View style={[styles.itemRow, styles.itemHeader]}>
              <View style={styles.itemTitle}>
                <Text style={styles.itemTag}>
                  <Font text={item.kind} />
                </Text>
                <Text style={styles.itemMainTitle}>
                  <Font text={item.title} />
                </Text>
              </View>
              <TouchableOpacity>
                <WithLocalSvg asset={Bookmark} />
              </TouchableOpacity>
            </View>
            <View style={styles.itemMiddle}>
              <Text style={styles.itemMiddleText}>
                <Font text={item.dept} />
              </Text>
              <Text style={styles.itemMiddleText}>
                <Font text={item.target} />
              </Text>
            </View>
            <View style={[styles.itemRow, styles.itemFooter]}>
              <Text style={styles.itemPeriod}>
                <Font text={item.period} />
              </Text>
              <Text style={styles.itemDday}>
                <Font text={item.dday} />
              </Text>
            </View>
          </TouchableOpacity>
        ))}
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {},
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
    borderBottomWidth: 1,
    borderBottomColor: '#8A8D92',
    paddingBottom: 15,
  },
  category: {
    flexDirection: 'row',
    paddingTop: 20,
  },
  categoryButton: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  categoryText: {
    fontSize: 20,
  },
  activeText: { color: '#000000' },
  list: {
    paddingVertical: 5,
    marginBottom: '41%',
  },
  item: {
    backgroundColor: '#ffffff',
    marginBottom: 5,
    paddingHorizontal: 20,
  },
  itemRow: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  itemHeader: {
    paddingVertical: 5,
  },
  itemMiddle: {
    flex: 1,
    justifyContent: 'flex-start',
  },
  itemFooter: {
    paddingVertical: 5,
    alignItems: 'flex-end',
  },
  itemTitle: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  itemTag: {
    color: '#3F86F8',
    borderWidth: 1,
    borderRadius: 50,
    borderColor: '#3F86F8',
    fontSize: 12,
    paddingHorizontal: 6,
    paddingVertical: 1,
    textAlignVertical: 'center',
    textAlign: 'center',
    marginRight: 10,
  },
  itemMainTitle: {
    fontSize: 20,
  },
  itemMiddleText: {
    fontSize: 13,
  },
  itemPeriod: {
    fontSize: 12,
  },
  itemDday: {
    color: '#ffffff',
    backgroundColor: '#3F86F8',
    borderRadius: 50,
    fontSize: 15,
    paddingVertical: 5,
    paddingHorizontal: 10,
  },
});

export default YouthPolicy;
