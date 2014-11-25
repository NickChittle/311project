if which ant > /dev/null; then
  ant junit
else
  echo "Please install ant: 'sudo apt-get install ant'"
fi
