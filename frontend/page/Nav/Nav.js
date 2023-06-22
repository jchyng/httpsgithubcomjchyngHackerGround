import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import React from 'react';
// import { StyleSheet } from 'react-native';
import Dash from './Dash';
import Job from './Job';
import YouthPolicy from './YouthPolicy';
import Setting from './Setting';
import { WithLocalSvg } from 'react-native-svg';
import DashSvg from '../../assets/dash.svg';
import DashActiveSvg from '../../assets/dash_active.svg';
import JobSvg from '../../assets/job.svg';
import JobActiveSvg from '../../assets/job_active.svg';
import YouthPolicySvg from '../../assets/youthPolicy.svg';
import YouthPolicyActiveSvg from '../../assets/youthPolicy_active.svg';
import SettingSvg from '../../assets/setting.svg';
import SettingActiveSvg from '../../assets/setting_active.svg';

const Tab = createBottomTabNavigator();

const Nav = () => {
  return (
    <Tab.Navigator
      initialRouteName="Dash"
      screenOptions={{
        headerShown: false,
        tabBarShowLabel: false,
        tabBarStyle: { height: 70 },
      }}>
      <Tab.Screen
        name="Dash"
        component={Dash}
        options={{
          tabBarIcon: ({ focused }) =>
            focused ? (
              <WithLocalSvg asset={DashActiveSvg} />
            ) : (
              <WithLocalSvg asset={DashSvg} />
            ),
        }}
      />
      <Tab.Screen
        name="Job"
        component={Job}
        options={{
          tabBarIcon: ({ focused }) =>
            focused ? (
              <WithLocalSvg asset={JobActiveSvg} />
            ) : (
              <WithLocalSvg asset={JobSvg} />
            ),
        }}
      />
      <Tab.Screen
        name="YouthPolicy"
        component={YouthPolicy}
        options={{
          tabBarIcon: ({ focused }) =>
            focused ? (
              <WithLocalSvg asset={YouthPolicyActiveSvg} />
            ) : (
              <WithLocalSvg asset={YouthPolicySvg} />
            ),
        }}
      />
      <Tab.Screen
        name="Setting"
        component={Setting}
        options={{
          tabBarIcon: ({ focused }) =>
            focused ? (
              <WithLocalSvg asset={SettingActiveSvg} />
            ) : (
              <WithLocalSvg asset={SettingSvg} />
            ),
        }}
      />
    </Tab.Navigator>
  );
};

// const styles = StyleSheet.create({});

export default Nav;
