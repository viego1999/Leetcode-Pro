# Read from the file file.txt and output the tenth line to stdout.
sed -n "10p" file.txt

awk "NR==10" file.txt

# tail -n +10 与 tail -n 10 不一样，-n +10 表示从第 10 行开始显示，若文件不足 10 行则什么也不会输出；-n 10 表示显示最后的 10 行
tail -n +10 file.txt | head -1